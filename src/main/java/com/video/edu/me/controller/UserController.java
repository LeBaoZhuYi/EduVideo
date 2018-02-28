package com.video.edu.me.controller;

import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.enumeration.RoleType;
import com.video.edu.me.service.TokenService;
import com.video.edu.me.service.UserService;
import com.video.edu.me.shiro.CustomizedToken;
import com.video.edu.me.utils.ObjectMapTransformUtil;
import com.video.edu.me.utils.AdjustEntityParamsUtil;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

//你好，我是乐宝
//哼，我才是
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> login(String loginName, String token, long timeStamp) {
        Map<String, Object> res = new HashMap<>();
        try {
            RoleType roleType = userService.getRole(loginName);
            if (!(roleType == RoleType.USER)){
                res.put("status", 3);
                res.put("msg", "不允许串号登录");
                res.put("data", null);
            } else {
                Subject subject = SecurityUtils.getSubject();
                CustomizedToken customizedToken = new CustomizedToken(loginName, String.format("%s+%d", token, timeStamp), RoleType.USER.getDesc());
                subject.login(customizedToken);
                UserExample userExample = new UserExample();
                userExample.createCriteria().andLoginNameEqualTo(loginName);
                User user = userService.selectByExample(userExample).get(0);
                // 更新最后一次登录时间
                user.setLastLoginTime(new Date());
                userService.updateByPrimaryKey(user);
                String accessToken = tokenService.afterLogin(user.getId());
                Map<String, Object> userMap = ObjectMapTransformUtil.obj2Map(user);
                AdjustEntityParamsUtil.removeParams(userMap, AdjustEntityParamsUtil.USER_USELESS_PARAMS);
                res.put("status", 0);
                res.put("msg", "");
                res.put("data", accessToken);
            }
        } catch (UnknownAccountException ue) {
            logger.error("login error with status: {}, loginName: {}, exception: {}", 1, loginName, ue.getMessage());
            res.put("status", 1);
            res.put("msg", "用户名不存在");
            res.put("data", null);
        } catch (AuthenticationException ae) {
            logger.error("login error with status: {}, loginName: {}, exception: {}", 2, loginName, ae.getMessage());
            res.put("status", 2);
            res.put("msg", "密码错误");
            res.put("data", null);
        } catch (RuntimeException re) {
            logger.error("update videoClass error with runtimException: {}", re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("login error with status: {}, loginName: {}, exception: {}", -1, loginName, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/noLogin", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> noLogin() throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> res = new HashMap<>();
        res.put("status", 101);
        res.put("msg", "noAuth");
        res.put("data", "noAuth");
        return res;
    }


    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> checkLogin(HttpServletRequest httpRequest) throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> res = new HashMap<>();
        Cookie[] cookies = httpRequest.getCookies();
        String token = "";
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }
        if (!tokenService.checkRole(token, RoleType.USER)) {
            res.put("status", -1);
            res.put("msg", "noAuth");
            res.put("data", "noAuth");
        } else {
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> logout(String token) {
        Map<String, Object> res = new HashMap<>();
        try {
            tokenService.clearingToken(token);
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", null);
        } catch (RuntimeException re) {
            logger.error("logout error with token: {}, runtimeException: {}", token, re.getMessage());
            res.put("status", 100);
            res.put("msg", re.getMessage());
            res.put("data", null);
        } catch (Exception e) {
            logger.error("logout error with token: {},  exception: {}", token, e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }
}

