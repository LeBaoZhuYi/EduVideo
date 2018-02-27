package com.video.edu.me.controller.admin;


import com.video.edu.me.entity.Video;
import com.video.edu.me.entity.VideoClass;
import com.video.edu.me.enumeration.VideoClassStatus;
import com.video.edu.me.qcloud.vod.VodApi;
import com.video.edu.me.service.StudentGroupService;
import com.video.edu.me.service.VideoClassService;
import com.video.edu.me.service.VideoService;
import com.video.edu.me.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminVideoClassController")
@RequestMapping(value = "/admin/videoClass")
public class VideoClassController {
    private static final Logger logger = LoggerFactory.getLogger(VideoClassController.class);

    @Autowired
    VideoClassService videoClassService;
    @Autowired
    VideoService videoService;
    @Autowired
    StudentGroupService studentGroupService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> create(@RequestParam Map<String, String> params) {
        Map<String, Object> res = new HashMap<>();
        try {
            VideoClass oldVideoClass = videoClassService.getTodayVideoClassByGroupId(Integer.parseInt(params.get("groupId")));
            if (oldVideoClass != null){
                res.put("status", 1);
                res.put("msg", "该分组今天已有课程");
                res.put("data", null);
            } else {
                VideoClass newVideoClass = new VideoClass();
                newVideoClass.setClassName(params.get("className"));
                newVideoClass.setTeacherName(params.get("teacherName"));
                newVideoClass.setGroupId(Integer.parseInt(params.get("groupId")));
                newVideoClass.setVideoId(Integer.parseInt(params.get("videoId")));
                newVideoClass.setStartTime(DateUtil.stringToDate(params.get("startTime")));
                newVideoClass.setEndTime(DateUtil.stringToDate(params.get("endTime")));
                boolean success = videoClassService.create(newVideoClass);
                if (!success) {
                    res.put("status", 2);
                    res.put("msg", "添加出错");
                    res.put("data", null);
                } else {
                    res.put("status", 0);
                    res.put("msg", "");
                    res.put("data", 1);
                }
            }
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
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
            VideoClass findResult = videoClassService.selectByPrimaryKey(id);
            if (findResult == null) {
                res.put("status", 1);
                res.put("msg", "查找视频失败");
            } else {
                res.put("status", 0);
                res.put("msg", "成功");
            }
            res.put("data", findResult);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("find error with exception: {}", e.getMessage());
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
            VideoClass videoClass = new VideoClass();
            videoClass.setId(id);
            videoClass.setStatus(VideoClassStatus.REMOVED.getId());
            int deleteResult = videoClassService.updateByPrimaryKeySelective(videoClass);
            if (deleteResult <= 0) {
                res.put("status", 1);
                res.put("msg", "未找到该课程");
            } else {
                res.put("status", 0);
                res.put("msg", "");
            }
            res.put("data", deleteResult);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("delete videoClass error with exception: {}", e.getMessage());
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
            VideoClass videoClass = videoClassService.selectByPrimaryKey(Integer.parseInt(params.get("id")));
            if (videoClass == null) {
                res.put("status", 1);
                res.put("msg", "未找到该课程");
                res.put("data", null);
            } else {
                if (params.get("className") != null) videoClass.setClassName(params.get("className"));
                if (params.get("teacherName") != null) videoClass.setTeacherName(params.get("teacherName"));
                if (params.get("videoId") != null) videoClass.setVideoId(Integer.parseInt(params.get("videoId")));
                if (params.get("groupId") != null) videoClass.setGroupId(Integer.parseInt(params.get("groupId")));
                if (params.get("status") != null)
                    videoClass.setStatus(VideoClassStatus.getByDesc(params.get("status")).getId());
                try {
                    if (params.get("startTime") != null)
                        videoClass.setStartTime(DateUtil.stringToDate(params.get("startTime")));
                    if (params.get("endTime") != null)
                        videoClass.setEndTime(DateUtil.stringToDate(params.get("endTime")));
                } catch (Exception e) {
                    throw new RuntimeException("时间格式错误");
                }
                boolean success = (1 == videoClassService.updateByPrimaryKeySelective(videoClass));
                if (!success) {
                    res.put("status", 1);
                    res.put("msg", "未找到课程");
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
            logger.error("update videoClass error with exception: {}", e.getMessage());
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
            List<VideoClass> videoClassList = videoClassService.getAllNotDeletedVideoClassList();
            List<Map<String, Object>> videoClassListMap = new ArrayList<>();
            for (VideoClass videoClass : videoClassList) {
                Map<String, Object> videoClassMap = ObjectMapTransformUtil.obj2Map(videoClass);
                AdjustEntityParamsUtil.removeParams(videoClassMap, AdjustEntityParamsUtil.VIDEO_LIST_USELESS_PARAMS);
                videoClassMap.put("videoTitle", videoService.getVideoTitleById(videoClass.getVideoId()));
                videoClassMap.put("groupName", studentGroupService.getStudentGroupNameById(videoClass.getGroupId()));
                videoClassMap.put("status", VideoClassStatus.getById(videoClass.getStatus()).getDesc());
                videoClassListMap.add(videoClassMap);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoClassListMap);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("get videoClass list error with exception: {}", e.getMessage());
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
            VodApi vodApi = new VodApi(Constants.SECRET_ID, Constants.SECRET_KEY);
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
//            VodBaseResponse vodBaseResponse = vodApi.upload(filePath);
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