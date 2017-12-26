package com.video.edu.me.service;

import com.video.edu.me.dao.HistoryMapper;
import com.video.edu.me.entity.History;
import com.video.edu.me.entity.HistoryExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HistoryService extends BaseService<History, HistoryExample> {

	private static final Logger logger = LoggerFactory.getLogger(HistoryService.class);

	private HistoryMapper historyMapper;

	@Resource
	public void setHistoryMapper(HistoryMapper historyMapper){
		this.historyMapper = historyMapper;
		super.setBaseDao(historyMapper);
	}
}
