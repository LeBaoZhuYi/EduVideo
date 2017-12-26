package com.video.edu.me.service;

import com.video.edu.me.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class BaseService<T, TExample> {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	/**
	 * 注入Service依赖
     * Spring4 之后才支持泛型注入，注意版本
	 */
	@Autowired
	private BaseDao<T, TExample> baseDao;

	public BaseDao<T, TExample> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T, TExample> baseDao) {
		this.baseDao = baseDao;
	}

	public int countByExample(TExample example){
		return baseDao.countByExample(example);
	}

	public int deleteByExample(TExample example){
		return baseDao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer id){
		return baseDao.deleteByPrimaryKey(id);
	}

	public int insert(T record){
		return baseDao.insert(record);
	}

	public int insertSelective(T record){
		return baseDao.insertSelective(record);
	}

	public List<T> selectByExample(TExample example){
		return baseDao.selectByExample(example);
	}

	public T selectByPrimaryKey(Integer id){
		return baseDao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(T record, TExample example){
		return baseDao.updateByExampleSelective(record, example);
	}

	public int updateByExample(T record, TExample example){
		return baseDao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(T record){
		return baseDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record){
		return baseDao.updateByPrimaryKey(record);
	}
}
