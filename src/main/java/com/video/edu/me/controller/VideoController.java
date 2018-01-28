package com.video.edu.me.controller;

import com.video.edu.me.entity.UserExample;
import com.video.edu.me.entity.VideoExample;
import com.video.edu.me.service.StudentService;
import com.video.edu.me.service.UserService;
import com.video.edu.me.service.VideoService;
import com.video.edu.me.entity.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/video")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(PlayPlanController.class);

    @Autowired
    VideoService videoService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    @ResponseBody
    private boolean today(int userId) throws IllegalArgumentException, IllegalAccessException {
        VideoExample videoExample = new VideoExample();
        return false;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private Video find(int id) throws IllegalArgumentException, IllegalAccessException {
        return videoService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private boolean delete(int id) throws IllegalArgumentException, IllegalAccessException {
        return videoService.deleteByPrimaryKey(id) != 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private boolean update(Video video) throws IllegalArgumentException, IllegalAccessException {
        return videoService.updateByPrimaryKey(video) != 0;
    }
}
