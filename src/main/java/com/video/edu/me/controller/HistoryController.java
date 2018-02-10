package com.video.edu.me.controller;

import com.video.edu.me.entity.Student;
import com.video.edu.me.service.HistoryService;
import com.video.edu.me.service.StudentService;
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
@RequestMapping(value = "/history")
public class HistoryController {

    private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    HistoryService historyService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> count(int userId){
        Map<String, Object> res = new HashMap<>();
        try {
            Student student = studentService.getStuIdByUserId(userId);
            int watchTimes = historyService.countWatchTimesByStuId(student.getId());
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", watchTimes);
        }catch (Exception e){
            logger.error("count history error with userId: {}, exception: {}", userId, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}
