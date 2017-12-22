package com.video.edu.me.controller;

import com.video.edu.me.model.User;
import com.video.edu.me.biz.UserBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserBiz userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	private User login(String login_name, String password, HttpSession session) throws IllegalArgumentException, IllegalAccessException {
		User user = null;
//		user = userService.login(login_name, new Tool().encodeMD5(password));
		//map.put相当于request.setAttribute方法
		if(user != null){
//			session.setAttribute("username", user.getUsername());
//			session.setAttribute("user_id", user.getId());
		}
		return user;
	}

}

