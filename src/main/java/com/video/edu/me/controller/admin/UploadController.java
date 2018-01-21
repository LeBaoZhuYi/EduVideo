package com.video.edu.me.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller("adminUploadController")
@RequestMapping(value = "/admin/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/video", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> video(HttpServletRequest httpServletRequest) {
        Map<String, Object> res = new HashMap<>();
        try {
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
            MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(httpServletRequest);
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

