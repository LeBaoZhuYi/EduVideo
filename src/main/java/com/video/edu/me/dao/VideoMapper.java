package com.video.edu.me.dao;

import com.video.edu.me.entity.Video;
import com.video.edu.me.entity.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper extends BaseDao<Video, VideoExample>{
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}