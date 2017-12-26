package com.video.edu.me.controller;

import com.video.edu.me.entity.User;
import com.video.edu.me.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//你好，我是乐宝
//哼，我才是
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	private int create(User user) throws IllegalArgumentException, IllegalAccessException {
		return userService.insert(user);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	private User find(int id) throws IllegalArgumentException, IllegalAccessException {
		return userService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	private int delete(int id) throws IllegalArgumentException, IllegalAccessException {
		return userService.deleteByPrimaryKey(id);
	}
}

