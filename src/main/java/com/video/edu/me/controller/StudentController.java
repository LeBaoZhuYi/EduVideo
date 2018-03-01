package com.video.edu.me.controller;

import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.User;
import com.video.edu.me.enumeration.SexType;
import com.video.edu.me.enumeration.StudentStatus;
import com.video.edu.me.service.StudentGroupService;
import com.video.edu.me.service.StudentService;
import com.video.edu.me.service.TokenService;
import com.video.edu.me.utils.AdjustEntityParamsUtil;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> info(String token){
        Map<String, Object> res = new HashMap<>();
        try {
            int userId = tokenService.getUserIdByToken(token);
            if (userId == -1){
                res.put("status", 102);
                res.put("msg", "当前登录信息已失效");
                res.put("data", null);
                return res;
            }
            Student student = studentService.getStudentByUserId(userId);
            Map<String, Object> studentMap = ObjectMapTransformUtil.obj2Map(student);
            AdjustEntityParamsUtil.removeParams(studentMap, AdjustEntityParamsUtil.COMMON_USELESS_PARAMS);
            String groupName = studentGroupService.getStudentGroupNameById(student.getGroupId());
            studentMap.put("groupName", groupName);
            studentMap.put("sex", SexType.getById(student.getSex()).getDesc());
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentMap);
        }catch (Exception e){
            logger.error("get student info error with token: {}, exception: {}", token, e.getMessage());
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
            String token = params.get("token");
            int userId = tokenService.getUserIdByToken(token);
            if (userId == -1){
                res.put("status", 102);
                res.put("msg", "当前登录信息已失效");
                res.put("data", null);
                return res;
            }
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                res.put("status", 1);
                res.put("msg", "未找到该学生");
                res.put("data", null);
            } else {
                if (params.get("studyName") != null) student.setStudyName(params.get("studyName"));
                if (params.get("birthday") != null) student.setBirthday(params.get("birthday"));
                if (params.get("phone") != null) student.setPhone(params.get("phone"));
                if (params.get("studyIntro") != null) student.setStudyIntro(params.get("studyIntro"));
                if (params.get("interest") != null) student.setInterest(params.get("interest"));
                if (params.get("ideal") != null) student.setIdeal(params.get("ideal"));
                if (params.get("disgree") != null) student.setDisagree(params.get("disgree"));
                if (params.get("parentWords") != null) student.setParentWords(params.get("parentWords"));
                studentService.updateByPrimaryKey(student);
                res.put("status", 0);
                res.put("msg", "更新成功");
                res.put("data", null);
            }
        } catch (RuntimeException re) {
            logger.error("update student error with runtimeException: {}", re.getMessage());
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
}

