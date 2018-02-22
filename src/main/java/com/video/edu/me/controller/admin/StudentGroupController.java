package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.StudentGroup;
import com.video.edu.me.service.StudentGroupService;
import com.video.edu.me.service.UserService;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminStudentGroupController")
@RequestMapping(value = "/admin/studentGroup")
public class StudentGroupController {

    private static final Logger logger = LoggerFactory.getLogger(StudentGroupController.class);

    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(StudentGroup studentGroup) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = studentGroupService.insertSelective(studentGroup);
            if (insertResult == 0) {
                res.put("status", 1);
                res.put("msg", "未成功插入数据");
            } else {
                res.put("status", 0);
                res.put("msg", "成功啦！");
            }
            res.put("data", insertResult);
        } catch (Exception e) {
            logger.error("create error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> delete(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            int deleteResult = studentGroupService.deleteByPrimaryKey(id);
            if (deleteResult == 0) {
                res.put("status", 1);
                res.put("msg", "删除出错");
            } else {
                res.put("status", 0);
                res.put("msg", "删除成功");
            }
            res.put("data", deleteResult);
        } catch (Exception e) {
            logger.error("delete error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> update(StudentGroup studentGroup) {
        Map<String, Object> res = new HashMap<>();
        try {
            int updateResult = studentGroupService.updateByPrimaryKey(studentGroup);
            if (updateResult == 0) {
                res.put("status", 1);
                res.put("msg", "更新失败");
            } else {
                res.put("status", 0);
                res.put("msg", "更新成功");
            }
            res.put("data", updateResult);
        } catch (Exception e) {
            logger.error("update error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getList() {
        Map<String, Object> res = new HashMap<>();
        try {
            List<StudentGroup> studentGroupList = studentGroupService.getAllNotDeletedStudentGroupList();
            List<Map<String, Object>> studentGroupListMap = new ArrayList<>();
            for(StudentGroup studentGroup: studentGroupList){
                studentGroupListMap.add(ObjectMapTransformUtil.obj2Map(studentGroup));
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentGroupListMap);
        } catch (Exception e) {
            logger.error("get studentGroup list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}

