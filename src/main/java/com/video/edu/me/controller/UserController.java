package com.video.edu.me.controller;

import com.video.edu.me.model.User;
//import com.video.edu.me.biz.UserBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
//你好，我是乐宝
//哼，我才是
/**
 * Handles requests for the application home page.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

//	@Autowired
//	UserBiz userService;
//
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	private String login(String login_name, String password, HttpSession session) throws IllegalArgumentException, IllegalAccessException {
		return "SUCCESS";
//		return "redirect:demo/login.html";
//		User user = null;
////		user = userService.login(login_name, new Tool().encodeMD5(password));
//		//map.put相当于request.setAttribute方法
//		if(user != null){
//			session.setAttribute("username", user.getUsername());
//			session.setAttribute("user_id", user.getId());
//		}
//		return user;
	}

}

