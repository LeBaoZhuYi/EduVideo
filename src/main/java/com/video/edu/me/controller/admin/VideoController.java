package com.video.edu.me.controller.admin;


import com.video.edu.me.enumeration.VideoStatus;
import com.video.edu.me.service.UploadService;
import com.video.edu.me.utils.AdjustEntityParamsUtil;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

import com.video.edu.me.entity.Video;
import com.video.edu.me.entity.VideoExample;
import com.video.edu.me.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.video.edu.me.qcloud.vod.VodApi;
import com.video.edu.me.qcloud.vod.response.VodBaseResponse;
import com.video.edu.me.utils.Constants;
import com.video.edu.me.utils.EncryptUtil;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> create(Video video) {
        Map<String, Object> res = new HashMap<>();
        try {
            boolean success = videoService.create(video);
            if (!success) {
                res.put("status", 1);
                res.put("msg", "添加s视频出错");
                res.put("data", null);
            } else {
                Thread uploadThread = new Thread(new UploadService(video.getId()));
                uploadThread.start();
                res.put("status", 0);
                res.put("msg", "");
                res.put("data", 1);
            }
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("create video error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
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
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("delete error with exception: {}", e.getMessage());
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
            Video video = videoService.selectByPrimaryKey(Integer.parseInt(params.get("id")));
            if (video == null) {
                res.put("status", 1);
                res.put("msg", "未找到该视频");
                res.put("data", null);
            } else {
                if (params.get("title") != null) video.setTitle(params.get("title"));
                if (params.get("comment") != null) video.setComment(params.get("comment"));
                if (params.get("status") != null) video.setStatus(VideoStatus.getByDesc(params.get("status")).getId());
                boolean success = (1 == videoService.updateByPrimaryKeySelective(video));
                if (!success) {
                    res.put("status", 1);
                    res.put("msg", "未找到视频");
                    res.put("data", null);
                } else {
                    res.put("status", 0);
                    res.put("msg", "更新成功");
                    res.put("data", null);
                }
            }
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("update error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/restartUpload", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> restartUpload(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            Video video = videoService.selectByPrimaryKey(id);
            if (video == null){
                res.put("status", 1);
                res.put("msg", "未找到视频");
                res.put("data", null);
            } else {
                Thread uploadThread = new Thread(new UploadService(video.getId()));
                uploadThread.start();
                res.put("status", 0);
                res.put("msg", "");
                res.put("data", null);
            }
        } catch (RuntimeException re) {
            logger.error("update video error with runtimeException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("update video error with exception: {}", e.getMessage());
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
            List<Video> videoList = videoService.getAllNotDeletedVideoList();
            List<Map<String, Object>> videoListMap = new ArrayList<>();
            for (Video video : videoList) {
                Map<String, Object> videoMap = ObjectMapTransformUtil.obj2Map(video);
                AdjustEntityParamsUtil.removeParams(videoMap, AdjustEntityParamsUtil.VIDEO_LIST_USELESS_PARAMS);
                videoMap.put("status", VideoStatus.getById(video.getStatus()).getDesc());
                videoListMap.add(videoMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoListMap);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get video list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getNormalList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getNormalList() {
        Map<String, Object> res = new HashMap<>();
        try {
            List<Video> videoList = videoService.getNormalVideoList();
            List<Map<String, Object>> videoListMap = new ArrayList<>();
            for (Video video : videoList) {
                Map<String, Object> videoMap = ObjectMapTransformUtil.obj2Map(video);
                AdjustEntityParamsUtil.removeParams(videoMap, AdjustEntityParamsUtil.VIDEO_LIST_USELESS_PARAMS);
                videoListMap.add(videoMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoListMap);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get normal video list error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> upload(HttpServletRequest httpServletRequest) {
        Map<String, Object> res = new HashMap<>();
        try {
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
            MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(httpServletRequest);        // 获得文件：
            MultipartFile multipartFile = multipartRequest.getFile("file");
            //判断后缀是否为常用视频格式
            String suffix = multipartFile.getContentType().split("/")[1];
            List<String> imageArray = new ArrayList<>();
            imageArray.add("mp4");
            imageArray.add("avi");
            imageArray.add("mkv");
            imageArray.add("flv");
            imageArray.add("wmv");
            imageArray.add("vob");
            if (!imageArray.contains(suffix.toLowerCase())) {
                throw new Exception("请选择正确视频格式文件");
            }
            // 获得文件名：
            String fileName = EncryptUtil.encoderByMd5(multipartFile.getOriginalFilename() + String.valueOf(System.currentTimeMillis())) + "." + suffix;

            String filePath = Constants.FILE_PATH + fileName;
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            multipartFile.transferTo(file);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", fileName);

        } catch (MultipartException me) {
            res.put("status", 1);
            res.put("msg", "");
            res.put("data", "上传已取消");
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", "");
        }
        return res;
    }

}