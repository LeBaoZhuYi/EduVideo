package com.video.edu.me.biz;

import com.video.edu.me.dao.UserDao;
import com.video.edu.me.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBiz extends BaseBiz<User> {
	
	private static final Logger logger = LoggerFactory.getLogger(UserBiz.class);

	private UserDao userDao;

	@Resource
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
		super.setBaseDao(userDao);
	}

	public User login(String login_name, String password){
		return userDao.login(login_name, password);
	}

}
