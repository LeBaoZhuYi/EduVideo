package com.video.edu.me.controller;

import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.service.UserService;
import com.video.edu.me.utils.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    private String login(User user, long timeStamp){
        try {
            Subject subject = SecurityUtils.getSubject() ;
            String encryptPassword = EncryptUtil.encoderByMd5(user.getPassword() + String.valueOf(timeStamp));
            UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), encryptPassword) ;
            subject.login(token);
            return "success" ;
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//            e.printStackTrace();
            return "fail" ;
        }

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
    private List<User> test2() throws IllegalArgumentException, IllegalAccessException {
        UserExample userExample = new UserExample();

        userExample.createCriteria().andLoginNameEqualTo("2");
        userExample.or().andLoginNameEqualTo("3");

        return userService.selectByExample(userExample);
    }
}

