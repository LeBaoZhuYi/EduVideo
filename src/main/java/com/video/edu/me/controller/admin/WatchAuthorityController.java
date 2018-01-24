package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.WatchAuthority;
import com.video.edu.me.entity.WatchAuthorityExample;
import com.video.edu.me.service.WatchAuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("adminWatchAuthorityController")
@RequestMapping(value = "/admin/watchAuthority")
public class WatchAuthorityController {
    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    WatchAuthorityService watchAuthorityService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(WatchAuthority watchAuthority) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = watchAuthorityService.insertSelective(watchAuthority);
            if (insertResult == 0) {
                res.put("status", 1);
                res.put("msg", "未成功插入视频权限");
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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> delete(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            int deleteResult = watchAuthorityService.deleteByPrimaryKey(id);
            if (deleteResult == 0) {
                res.put("status", 1);
                res.put("msg", "删除视频授权出错");
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

    @RequestMapping(value = "/getStuListByVideoID", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getStuListByVideoID(int videoId) {
        Map<String, Object> res = new HashMap<>();
        try {
            WatchAuthorityExample watchAuthorityExample = new WatchAuthorityExample();
            watchAuthorityExample.createCriteria().andVideoIdEqualTo(videoId);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", watchAuthorityService.selectByExample(watchAuthorityExample));
        } catch (Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getVideoListByStuId", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getVideoListByStuId(int stuId) {
        Map<String, Object> res = new HashMap<>();
        try {
            WatchAuthorityExample watchAuthorityExample = new WatchAuthorityExample();
            watchAuthorityExample.createCriteria().andStuIdEqualTo(stuId);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", watchAuthorityService.selectByExample(watchAuthorityExample));
        } catch (Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}
