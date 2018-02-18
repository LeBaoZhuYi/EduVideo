package com.video.edu.me.controller;

import com.video.edu.me.entity.Student;
import com.video.edu.me.service.StudentService;
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

    @RequestMapping(value = "/getBaseInfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getBaseInfo(int userId){
        Map<String, Object> res = new HashMap<>();
        try {
            Student student = studentService.getStuIdByUserId(userId);
            Map<String, Object> studentMap = ObjectMapTransformUtil.obj2Map(student);
            AdjustEntityParamsUtil.reserveParams(studentMap, AdjustEntityParamsUtil.STUDENT_BASE_INFO_PARAMS);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentMap);
        }catch (Exception e){
            logger.error("get student info error with userId: {}, exception: {}", userId, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}

