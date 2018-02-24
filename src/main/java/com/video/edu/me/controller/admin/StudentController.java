package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.StudentExample;
import com.video.edu.me.entity.User;
import com.video.edu.me.service.StudentGroupService;
import com.video.edu.me.service.StudentService;
import com.video.edu.me.service.UserService;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminStudentController")
@RequestMapping(value = "/admin/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;
    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> create(@RequestParam Map<String, String> params) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = 0;
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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> delete(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            int deleteResult = studentService.deleteByPrimaryKey(id);
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

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> update(Student student) {
        Map<String, Object> res = new HashMap<>();
        try {
            int updateResult = studentService.updateByPrimaryKey(student);
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
            List<Student> studentList = studentService.getAllNotDeletedStudentList();
            List<Map<String, Object>> studentListMap = new ArrayList<>();
            for(Student student: studentList){
                Map<String, Object> studentMap = ObjectMapTransformUtil.obj2Map(student);
                studentMap.put("groupName", studentGroupService.getStudentGroupNameById(student.getGroupId()));
                studentMap.put("loginName", userService.getLoginNameById(student.getGroupId()));
                studentListMap.add(studentMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentListMap);
        } catch (Exception e) {
            logger.error("get student list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}

