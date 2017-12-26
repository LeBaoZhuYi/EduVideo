package com.video.edu.me.service;

import com.video.edu.me.dao.PlayPlanMapper;
import com.video.edu.me.entity.PlayPlan;
import com.video.edu.me.entity.PlayPlanExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlayPlanService extends BaseService<PlayPlan, PlayPlanExample> {

	private static final Logger logger = LoggerFactory.getLogger(PlayPlanService.class);
	
	private PlayPlanMapper playPlanMapper;

	@Resource
	public void setPlayPlanMapper(PlayPlanMapper playPlanMapper){
		this.playPlanMapper = playPlanMapper;
		super.setBaseDao(playPlanMapper);
	}
}
