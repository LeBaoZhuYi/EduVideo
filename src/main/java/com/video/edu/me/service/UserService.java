package com.video.edu.me.service;

import com.video.edu.me.dao.UserMapper;
import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends BaseService<User, UserExample> {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private UserMapper userMapper;

	@Resource
	public void setUserMapper(UserMapper userMapper){
		this.userMapper = userMapper;
		super.setBaseDao(userMapper);
	}
}
