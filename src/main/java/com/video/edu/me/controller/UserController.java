package com.video.edu.me.controller;

import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.service.UserService;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import com.video.edu.me.utils.RemoveEntityParamsUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

//你好，我是乐宝
//哼，我才是
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private boolean update(User user) throws IllegalArgumentException, IllegalAccessException {
        return userService.updateByPrimaryKey(user) != 0;
    }

    /**
     * 获取状态在0-2的时间早于今天凌晨产生的用户，按utime排序
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> login(String loginName, String token, long timeStamp){
        Map<String, Object> res = new HashMap<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName, String.format("%s+%d", token, timeStamp));
            subject.login(usernamePasswordToken);
            UserExample userExample = new UserExample();
            userExample.createCriteria().andLoginNameEqualTo(loginName);
            User user = userService.selectByExample(userExample).get(0);
            Map<String, Object> userMap = ObjectMapTransformUtil.obj2Map(user);
            RemoveEntityParamsUtil.removeParams(userMap, RemoveEntityParamsUtil.USER_USELESS_PARAMS);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", userMap);
        } catch (UnknownAccountException ue){
            logger.error("login error with status: {}, loginName: {}, exception: {}", 1, loginName, ue.getMessage());
            res.put("status", 1);
            res.put("msg", "用户名不存在");
            res.put("data", null);
        } catch (AuthenticationException ae){
            logger.error("login error with status: {}, loginName: {}, exception: {}", 2, loginName, ae.getMessage());
            res.put("status", 2);
            res.put("msg", "密码错误");
            res.put("data", null);
        }catch (Exception e){
            logger.error("login error with status: {}, loginName: {}, exception: {}", -1, loginName, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/noLogin", method = RequestMethod.GET)
    @ResponseBody
    private String noLogin() throws IllegalArgumentException, IllegalAccessException {
        return "no auth";

    }

    /**
     * 获取loginName为2或3的用户
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> test2(){
        Map<String, Object> res = new HashMap<>();
        try {
            UserExample userExample = new UserExample();

            userExample.createCriteria().andLoginNameEqualTo("2");
            userExample.or().andLoginNameEqualTo("3");

            res.put("status", 0);
            res.put("msg", "");
            res.put("data", userService.selectByExample(userExample));
        } catch(Exception e){
            logger.error("test2 error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);

        }
        return res;
    }
}

