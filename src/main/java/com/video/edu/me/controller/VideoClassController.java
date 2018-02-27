package com.video.edu.me.controller;

import com.video.edu.me.entity.*;
import com.video.edu.me.enumeration.StudentClassInfoStatus;
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
@RequestMapping(value = "/videoClass")
public class VideoClassController {

    private static final Logger logger = LoggerFactory.getLogger(VideoClassController.class);

    @Autowired
    VideoClassService videoClassService;
    @Autowired
    StudentClassInfoService studentClassInfoService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/classList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> classList(int userId) {
        Map<String, Object> res = new HashMap<>();
        try {
            List<VideoClass> currentMonthClassList = videoClassService.getCurrentMonthClassListByUserId(userId);
            List<Map<String, Object>> videoClassMapList = new ArrayList<>();
            for (VideoClass videoClass : currentMonthClassList) {
                Map<String, Object> videoClassMap = ObjectMapTransformUtil.obj2Map(videoClass);
                AdjustEntityParamsUtil.reserveParams(videoClassMap, AdjustEntityParamsUtil.VIDEO_CLASS_LIST_USEFUL_PARAMS);
                videoClassMapList.add(videoClassMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoClassMapList);
        } catch (RuntimeException re) {
            logger.error("get videoClassList error with userId: {}, runtimeException: {}", userId, re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get videoClassList error with userId: {}, exception: {}", userId, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> today(int userId) {
        Map<String, Object> res = new HashMap<>();
        try {
            Map<String, Object> data = new HashMap<>();
            VideoClass todayVideoClass = videoClassService.getTodayVideoClassByUserId(userId);
            if (todayVideoClass == null){
                res.put("status", 1);
                res.put("msg", "今日无课程");
                res.put("data", data);
            }
            Student student = studentService.getStudentByUserId(userId);
            StudentClassInfo studentClassInfo = studentClassInfoService.getLastStudentClassInfoByClassIdAndStudentId(student.getId(), todayVideoClass.getId());
            data.put("isWatched", false);
            if (studentClassInfo != null && studentClassInfo.getStatus() == StudentClassInfoStatus.END.getId()) {
                data.put("isWatched", true);
            }
            data.put("videoTitle", todayVideoClass.getClassName());
            data.put("classTimes", studentClassInfoService.countFinishedClassTimesByStudentId(student.getId()));
            data.put("todayClassStartTime", todayVideoClass.getStartTime());
            data.put("todayClassEndTime", todayVideoClass.getEndTime());
            data.put("teacherName", todayVideoClass.getTeacherName());
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", data);
        } catch (RuntimeException re) {
            logger.error("get today class info error with userId: {}, runtimeException: {}", userId, re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get today class info error with userId: {}, exception: {}", userId, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}
