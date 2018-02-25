package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.StudentExample;
import com.video.edu.me.entity.User;
import com.video.edu.me.enumeration.RoleType;
import com.video.edu.me.enumeration.SexType;
import com.video.edu.me.enumeration.StudentStatus;
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
            User newUser = new User();
            newUser.setLoginName(params.get("loginName"));
            newUser.setPassword(params.get("password"));
            newUser.setRoleId(RoleType.USER.getId());
            Student newStudent = new Student();
            newStudent.setStudyName(params.get("studyName"));
            newStudent.setStudyId(params.get("studyId"));
            newStudent.setPhone(params.get("phone"));
            newStudent.setSex(SexType.getByDesc(params.get("sex")).getId());
            newStudent.setGroupId(Integer.parseInt(params.get("groupId")));
            boolean success = userService.create(newUser);
            if (!success) {
                res.put("status", 1);
                res.put("msg", "添加用户出错");
                res.put("data", null);
            } else {
                newStudent.setUserId(newUser.getId());
                success = success && studentService.create(newStudent);
                if (!success) {
                    res.put("status", 2);
                    res.put("msg", "添加学生出错");
                    res.put("data", null);
                } else {
                    res.put("status", 0);
                    res.put("msg", "");
                    res.put("data", 1);
                }
            }
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("create student error with exception: {}", e.getMessage());
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
            Student student = new Student();
            student.setId(id);
            student.setStatus(StudentStatus.REMOVED.getId());
            int deleteResult = studentService.updateByPrimaryKeySelective(student);
            if (deleteResult <= 0) {
                res.put("status", 1);
                res.put("msg", "未找到该学生");
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
            logger.error("delete student error with exception: {}", e.getMessage());
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
            Student student = studentService.selectByPrimaryKey(Integer.parseInt(params.get("id")));
            if (student == null) {
                res.put("status", 1);
                res.put("msg", "未找到该学生");
                res.put("data", null);
            } else {
                if (params.get("studyName") != null) student.setStudyName(params.get("studyName"));
                if (params.get("studyIntro") != null) student.setStudyIntro(params.get("studyIntro"));
                if (params.get("teacherRemark") != null) student.setTeacherRemark(params.get("teacherRemark"));
                if (params.get("studyId") != null) student.setStudyId(params.get("studyId"));
                if (params.get("status") != null)
                    student.setStatus(StudentStatus.getByDesc(params.get("status")).getId());
                if (params.get("studyName") != null) student.setStudyName(params.get("studyName"));
                if (params.get("groupId") != null) student.setGroupId(Integer.parseInt(params.get("groupId")));
                boolean success = (1 == studentService.updateByPrimaryKeySelective(student));
                if (params.get("loginName") != null) {
                    User user = userService.selectByPrimaryKey(student.getUserId());
                    user.setLoginName(params.get("loginName"));
                    success = success && (1 == userService.updateByPrimaryKeySelective(user));
                }
                if (!success) {
                    res.put("status", 2);
                    res.put("msg", "未找到用户");
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
            List<Student> studentList = studentService.getAllNotDeletedStudentList();
            List<Map<String, Object>> studentListMap = new ArrayList<>();
            for (Student student : studentList) {
                Map<String, Object> studentMap = ObjectMapTransformUtil.obj2Map(student);
                studentMap.put("groupName", studentGroupService.getStudentGroupNameById(student.getGroupId()));
                studentMap.put("loginName", userService.getLoginNameById(student.getUserId()));
                studentMap.put("status", StudentStatus.getById((byte) studentMap.get("status")).getDesc());
                studentListMap.add(studentMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentListMap);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get student list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}

