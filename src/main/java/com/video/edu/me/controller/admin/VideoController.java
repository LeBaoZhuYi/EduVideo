package com.video.edu.me.controller.admin;

import com.video.edu.me.qcloud.vod.VodApi;
import com.video.edu.me.qcloud.vod.response.VodBaseResponse;
import com.video.edu.me.utils.Constants;
import com.video.edu.me.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.*;

@Controller("adminUploadController")
@RequestMapping(value = "/admin/video")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

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
            VodBaseResponse vodBaseResponse = vodApi.upload(filePath);
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

