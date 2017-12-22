package com.video.edu.me.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.video.edu.me.dao.BaseDao;

import java.util.ArrayList;
import java.util.Map;

public class BaseBiz<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseBiz.class);

	/**
	 * 注入Service依赖
     * Spring4 之后才支持泛型注入，注意版本
	 */
	@Autowired
	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
}
