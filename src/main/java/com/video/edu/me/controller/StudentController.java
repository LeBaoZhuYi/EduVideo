package com.video.edu.me.controller;

import com.video.edu.me.entity.Student;
import com.video.edu.me.enumeration.SexType;
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

}

