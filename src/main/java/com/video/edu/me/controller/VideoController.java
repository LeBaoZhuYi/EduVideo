package com.video.edu.me.controller;

import com.video.edu.me.entity.*;
import com.video.edu.me.enumeration.VideoStatus;
import com.video.edu.me.service.*;
import com.video.edu.me.utils.DateUtil;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import com.video.edu.me.utils.AdjustEntityParamsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/video")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    VideoService videoService;
    @Autowired
    VideoClassService videoClassService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> play(int userId, int videoId) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (videoId == -1) {
                VideoClass videoClass = videoClassService.getTodayVideoClassByUserId(userId);
                if (videoClass == null) {
                    res.put("status", 1);
                    res.put("msg", "今日没有课程");
                    res.put("data", null);
                    return res;
                }
                Date now = new Date();
                if (now.compareTo(videoClass.getStartTime()) < 0) {
                    res.put("status", 2);
                    res.put("msg", "未到课程开始时间");
                    res.put("data", null);
                    return res;
                } else if (now.compareTo(videoClass.getEndTime()) > 0) {
                    res.put("status", 2);
                    res.put("msg", "今日课程已经结束");
                    res.put("data", null);
                    return res;
                }
                videoId = videoClass.getVideoId();
            }
            Video video = videoService.selectByPrimaryKey(videoId);
            Map<String, Object> videoMap = ObjectMapTransformUtil.obj2Map(video);
            AdjustEntityParamsUtil.removeParams(videoMap, AdjustEntityParamsUtil.COMMON_USELESS_PARAMS);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoMap);
        } catch (Exception e) {
            logger.error("play video error with userId: {}, videoId: {}, exception: {}", userId, videoId, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}
