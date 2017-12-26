package com.video.edu.me.service;

import com.video.edu.me.dao.WatchAuthorityMapper;
import com.video.edu.me.entity.WatchAuthority;
import com.video.edu.me.entity.WatchAuthorityExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WatchAuthorityService extends BaseService<WatchAuthority, WatchAuthorityExample> {

	private static final Logger logger = LoggerFactory.getLogger(WatchAuthorityService.class);

	private WatchAuthorityMapper watchAuthorityMapper;

	@Resource
	public void setWatchAuthorityMapper(WatchAuthorityMapper watchAuthorityMapper){
		this.watchAuthorityMapper = watchAuthorityMapper;
		super.setBaseDao(watchAuthorityMapper);
	}
}
