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
	
	public ArrayList<T> all() {
		return baseDao.all();
	}

	public int update(T t){
		return baseDao.update(t);
	}
	
	public int insert(T t) {
		return baseDao.insert(t);
	}

	public int delete(int id) {
		return baseDao.delete(id);
	}

	public ArrayList<T> find(Map map) {
		return baseDao.find(map);
	}

	
	public T findByIntId(int id) {
		return baseDao.findByIntId(id);
	}
	
	public T findByStringId(String t_id) {
		return baseDao.findByStringId(t_id);
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
}
