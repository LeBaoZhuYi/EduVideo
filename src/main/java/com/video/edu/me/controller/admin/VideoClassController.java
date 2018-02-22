package com.video.edu.me.controller.admin;


import com.video.edu.me.entity.VideoClass;
import com.video.edu.me.qcloud.vod.VodApi;
import com.video.edu.me.service.VideoClassService;
import com.video.edu.me.utils.AdjustEntityParamsUtil;
import com.video.edu.me.utils.Constants;
import com.video.edu.me.utils.EncryptUtil;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(VideoClass videoClass) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = videoClassService.insertSelective(videoClass);
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
            VideoClass findResult = videoClassService.selectByPrimaryKey(id);
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
            int deleteResult = videoClassService.deleteByPrimaryKey(id);
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
    private Map<String, Object> update(VideoClass videoClass) {
        Map<String, Object> res = new HashMap<>();
        try {
            int updateResult = videoClassService.updateByPrimaryKey(videoClass);
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
            List<VideoClass> videoClassList = videoClassService.getAllNotDeletedVideoClassList();
            List<Map<String, Object>> videoClassListMap = new ArrayList<>();
            for(VideoClass videoClass: videoClassList){
                Map<String, Object> videoClassMap = ObjectMapTransformUtil.obj2Map(videoClass);
                AdjustEntityParamsUtil.removeParams(videoClassMap, AdjustEntityParamsUtil.VIDEO_LIST_USELESS_PARAMS);
            }
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", videoClassListMap);
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
            if(!imageArray.contains(suffix.toLowerCase())){
                throw new Exception("请选择正确视频格式文件");
            }
            // 获得文件名：
            String fileName = EncryptUtil.encoderByMd5(multipartFile.getOriginalFilename() + String.valueOf(System.currentTimeMillis())) + "." + suffix;

            String filePath = Constants.FILE_PATH + fileName;
            File file = new File(filePath);
            if(!file.getParentFile().exists()){
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
        } catch (Exception e) {
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", "");
        }
        return res;
    }

}