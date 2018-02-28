package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.StudentGroup;
import com.video.edu.me.enumeration.StudentGroupStatus;
import com.video.edu.me.service.StudentGroupService;
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

@Controller("adminStudentGroupController")
@RequestMapping(value = "/admin/studentGroup")
public class StudentGroupController {

    private static final Logger logger = LoggerFactory.getLogger(StudentGroupController.class);

    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> create(StudentGroup studentGroup) {
        Map<String, Object> res = new HashMap<>();
        try {
            boolean success = studentGroupService.create(studentGroup);
            if (!success) {
                res.put("status", 1);
                res.put("msg", "添加分组出错");
                res.put("data", null);
            } else {
                res.put("status", 0);
                res.put("msg", "");
                res.put("data", 1);
            }
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("create studentGroup error with exception: {}", e.getMessage());
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
            StudentGroup studentGroup = new StudentGroup();
            studentGroup.setId(id);
            studentGroup.setStatus(StudentGroupStatus.REMOVED.getId());
            int deleteResult = studentGroupService.updateByPrimaryKeySelective(studentGroup);
            if (deleteResult <= 0) {
                res.put("status", 1);
                res.put("msg", "未找到该分组");
            } else {
                res.put("status", 0);
                res.put("msg", "");
            }
            res.put("data", deleteResult);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("delete studentGroup error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> update(@RequestParam Map<String, String> params) {
        Map<String, Object> res = new HashMap<>();
        try {
            StudentGroup studentGroup = studentGroupService.selectByPrimaryKey(Integer.parseInt(params.get("id")));
            if (studentGroup == null) {
                res.put("status", 1);
                res.put("msg", "未找到该分组");
                res.put("data", null);
            } else {
                if (params.get("name") != null) studentGroup.setName(params.get("name"));
                if (params.get("remark") != null) studentGroup.setRemark(params.get("remark"));
                if (params.get("status") != null) studentGroup.setStatus(StudentGroupStatus.getByDesc(params.get("status")).getId());
                boolean success = (1 == studentGroupService.updateByPrimaryKeySelective(studentGroup));
                if (!success) {
                    res.put("status", 1);
                    res.put("msg", "未找到分组");
                    res.put("data", null);
                } else {
                    res.put("status", 0);
                    res.put("msg", "更新成功");
                    res.put("data", null);
                }
            }
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("update student error with exception: {}", e.getMessage());
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
            for (StudentGroup studentGroup : studentGroupList) {
                Map<String, Object> studentGroupMap = ObjectMapTransformUtil.obj2Map(studentGroup);
                studentGroupMap.put("status", StudentGroupStatus.getById(studentGroup.getStatus()).getDesc());
                studentGroupListMap.add(studentGroupMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentGroupListMap);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get studentGroup list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getNormalList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getNormalList() {
        Map<String, Object> res = new HashMap<>();
        try {
            List<StudentGroup> studentGroupList = studentGroupService.getNormalStudentGroupList();
            List<Map<String, Object>> studentGroupListMap = new ArrayList<>();
            for (StudentGroup studentGroup : studentGroupList) {
                studentGroupListMap.add(ObjectMapTransformUtil.obj2Map(studentGroup));
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentGroupListMap);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get normal studentGroup list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}

