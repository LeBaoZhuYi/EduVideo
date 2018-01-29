package com.video.edu.me.service;

import com.video.edu.me.dao.ScoreMapper;
import com.video.edu.me.entity.Score;
import com.video.edu.me.entity.ScoreExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScoreService extends BaseService<Score, ScoreExample> {

	private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

	private ScoreMapper scoreMapper;

	@Resource
	public void setScoreMapper(ScoreMapper scoreMapper){
		this.scoreMapper = scoreMapper;
		super.setBaseDao(scoreMapper);
	}
}
