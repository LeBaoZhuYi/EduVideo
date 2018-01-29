package com.video.edu.me.dao;

import com.video.edu.me.entity.VideoClass;
import com.video.edu.me.entity.VideoClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface VideoClassMapper extends BaseDao<VideoClass, VideoClassExample> {
    int countByExample(VideoClassExample example);

    int deleteByExample(VideoClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoClass record);

    int insertSelective(VideoClass record);

    List<VideoClass> selectByExample(VideoClassExample example);

    VideoClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoClass record, @Param("example") VideoClassExample example);

    int updateByExample(@Param("record") VideoClass record, @Param("example") VideoClassExample example);

    int updateByPrimaryKeySelective(VideoClass record);

    int updateByPrimaryKey(VideoClass record);
}