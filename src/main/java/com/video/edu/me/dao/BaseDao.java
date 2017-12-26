package com.video.edu.me.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T, TExample> {
    int countByExample(TExample example);

    int deleteByExample(TExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TExample example);

    T selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") TExample example);

    int updateByExample(@Param("record") T record, @Param("example") TExample example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}