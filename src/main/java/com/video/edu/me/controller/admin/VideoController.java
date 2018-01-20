package com.video.edu.me.controller.admin;


import com.video.edu.me.entity.Video;
import com.video.edu.me.entity.VideoExample;
import com.video.edu.me.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("adminVideoController")
@RequestMapping(value = "/admin/video")
public class VideoController {
    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(Video video) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = videoService.insertSelective(video);
            if (insertResult == 0) {
                res.put("status", 1);
                res.put("msg", "未成功插入视频");
            } else {
                res.put("status", 0);
                res.put("msg", "成功啦！");
            }
            res.put("data", insertResult);
        } catch (Exception e) {
            logger.error("create error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> find(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            Video findResult = videoService.selectByPrimaryKey(id);
            if (findResult == null) {
                res.put("status", 1);
                res.put("msg", "查找视频失败");
            } else {
                res.put("status", 0);
                res.put("msg", "成功");
            }
            res.put("data", findResult);
        } catch (Exception e) {
            logger.error("find error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> delete(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            int deleteResult = videoService.deleteByPrimaryKey(id);
            if (deleteResult == 0) {
                res.put("status", 1);
                res.put("msg", "删除视频出错");
            } else {
                res.put("status", 0);
                res.put("msg", "删除成功");
            }
            res.put("data", deleteResult);
        } catch (Exception e) {
            logger.error("delete error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> update(Video video) {
        Map<String, Object> res = new HashMap<>();
        try {
            int updateResult = videoService.updateByPrimaryKey(video);
            if (updateResult == 0) {
                res.put("status", 1);
                res.put("msg", "更新视频失败");
            } else {
                res.put("status", 0);
                res.put("msg", "更新成功");
            }
            res.put("data", updateResult);
        } catch (Exception e) {
            logger.error("update error with exception: {}", e.getMessage());
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
            VideoExample videoExample = new VideoExample();
            videoExample.createCriteria().andIdIsNotNull();
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoService.selectByExample(videoExample));
        } catch (Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getTeacherList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getTeacherList() {
        Map<String, Object> res = new HashMap<>();
        try {
            VideoExample videoExample = new VideoExample();
            videoExample.createCriteria().andTeacherNameLike("a");
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoService.selectByExample(videoExample));
        } catch (Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}
