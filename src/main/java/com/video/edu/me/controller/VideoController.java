package com.video.edu.me.controller;

import com.video.edu.me.entity.*;
import com.video.edu.me.enumeration.VideoStatus;
import com.video.edu.me.service.*;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import com.video.edu.me.utils.RemoveEntityParamsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/video")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(PlayPlanController.class);

    @Autowired
    VideoService videoService;
    @Autowired
    VideoClassService videoClassService;
    @Autowired
    WatchAuthorityService watchAuthorityService;

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> today(int stuId){
        Map<String, Object> res = new HashMap<>();
        try {
            VideoClass videoClass = videoClassService.getTodayVideoClass();
            if (videoClass == null) {
                res.put("status", "1");
                res.put("msg", "今日没有课程");
                res.put("data", null);
            } else {
                WatchAuthorityExample watchAuthorityExample = new WatchAuthorityExample();
                watchAuthorityExample.createCriteria().andStuIdEqualTo(stuId).andVideoIdEqualTo(videoClass.getVideoId());
                if (watchAuthorityService.countByExample(watchAuthorityExample) > 0) {
                    VideoExample videoExample = new VideoExample();
                    videoExample.createCriteria().andIdEqualTo(videoClass.getVideoId()).andStatusEqualTo(VideoStatus.NORMAL.getId());
                    List<Video> videoList = videoService.selectByExample(videoExample);
                    Map<String, Object> userMap = ObjectMapTransformUtil.obj2Map(videoList.get(0));
                    RemoveEntityParamsUtil.removeParams(userMap, RemoveEntityParamsUtil.VIDEO_USELESS_PARAMS);
                    res.put("status", "0");
                    res.put("msg", "");
                    res.put("data", userMap);
                }
            }
        } catch (Exception e){
            logger.error("get today video error with stuId: {}, exception: {}", stuId, e.getMessage());
            res.put("status", "-1");
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}
