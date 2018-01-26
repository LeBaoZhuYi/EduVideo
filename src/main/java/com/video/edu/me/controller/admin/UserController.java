package com.video.edu.me.controller.admin;


import com.video.edu.me.entity.History;
import com.video.edu.me.entity.HistoryExample;
import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.service.HistoryService;
import com.video.edu.me.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminUserController")
@RequestMapping(value = "/admin/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(User user) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = userService.insertSelective(user);
            if (insertResult == 0) {
                res.put("status", 1);
                res.put("msg", "未成功插入用户");
            } else {
                res.put("status", 0);
                res.put("msg", "创建用户成功！");
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
            User findResult = userService.selectByPrimaryKey(id);
            if (findResult == null) {
                res.put("status", 1);
                res.put("msg", "查找用户失败");
            } else {
                res.put("status", 0);
                res.put("msg", "查找用户成功");
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
            int deleteResult = userService.deleteByPrimaryKey(id);
            if (deleteResult == 0) {
                res.put("status", 1);
                res.put("msg", "删除用户出错");
            } else {
                res.put("status", 0);
                res.put("msg", "删除用户成功");
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

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getUserList() {
        Map<String, Object> res = new HashMap<>();
        try {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdIsNotNull();
            if(userExample == null){
                res.put("status", 1);
                res.put("msg", "获取用户列表失败");
            }else{
                res.put("status", 0);
                res.put("msg", "");
                res.put("data", userService.selectByExample(userExample));
            }
        } catch (Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}
