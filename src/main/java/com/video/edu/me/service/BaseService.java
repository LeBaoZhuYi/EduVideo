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
		/**
		 * 这里就是Service层，它被Controller层调用，自身调用DAO层
		 * baseDao也是个bean，它也有@Autowired注解
		 *
		 * 而BaseDao脑袋上的@Repository也是用来告诉spring我有bean的
		 * 刚刚的@Service，这个@Repository，已经Controller层的@Controller，这三个注解标注的类，spring都会觉得他们有bean
		 *
		 * 再ctrl+点击看这个函数的时候，乐宝跳到接口类BaseDao上，上面看不到具体的实现，乐宝可以注意到看BaseDao文件的时候左边有很多绿点加向下的箭头，每个对应一个接口方法
		 * 其实点这些绿点是可以看到这个接口方法有哪些类继承或者实现了的
		 *
		 * 这里要讲一下MyBatis，因为它，insertSelective的实际实现是在com.video.edu.me.mapper.*.xml里面了，乐宝打开里面的UserMapper.xml
		 * 用ctrl+f 搜索insertSelective
		 * 可以看到它在一个insert标签里，有一句insert into user，下面有很多if啥的，乐宝现在可以先不用理解它是啥意思，只要知道它最后形成的sql语句是
		 * INSERT INTO `edu_video`.`user`(`login_name`, `password`, `status`, `role_id`) VALUES ('1', '2', 0, 1);
		 * 这一层也不用太关注，主要是实现Controller层和Service层的逻辑

		 */
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
