package com.video.edu.me.controller;

import com.video.edu.me.entity.*;
import com.video.edu.me.service.*;
import com.video.edu.me.utils.AdjustEntityParamsUtil;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/studentClassInfo")
public class StudentClassInfoController {

    private static final Logger logger = LoggerFactory.getLogger(StudentClassInfoController.class);

    @Autowired
    VideoClassService videoClassService;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentClassInfoService studentClassInfoService;

    @RequestMapping(value = "/lastClassInfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> lastClassInfo(int userId) {
        Map<String, Object> res = new HashMap<>();
        try {
            Student student = studentService.getStuIdByUserId(userId);
            StudentClassInfoExample studentClassInfoExample = new StudentClassInfoExample();
            studentClassInfoExample.createCriteria().andStuIdEqualTo(student.getId());
            studentClassInfoExample.setOrderByClause("ctime DESC");
            List<StudentClassInfo> studentClassInfoList = studentClassInfoService.selectByExample(studentClassInfoExample);
            if(studentClassInfoList.size() == 0){

            } else{
                StudentClassInfo lastStudentClassInfo = studentClassInfoList.get(0);
                Map<String, Object> studentClassInfoMap = ObjectMapTransformUtil.obj2Map(lastStudentClassInfo);
                AdjustEntityParamsUtil.removeParams(studentClassInfoMap, AdjustEntityParamsUtil.COMMON_USELESS_PARAMS);
                res.put("status", 0);
                res.put("msg", "");
                res.put("data", studentClassInfoMap);
            }
        } catch (Exception e) {
            logger.error("play video error with userId: {}, exception: {}", userId, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}
