package com.video.edu.me.dao;

import com.video.edu.me.entity.WatchAuthority;
import com.video.edu.me.entity.WatchAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WatchAuthorityMapper {
    int countByExample(WatchAuthorityExample example);

    int deleteByExample(WatchAuthorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WatchAuthority record);

    int insertSelective(WatchAuthority record);

    List<WatchAuthority> selectByExample(WatchAuthorityExample example);

    WatchAuthority selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WatchAuthority record, @Param("example") WatchAuthorityExample example);

    int updateByExample(@Param("record") WatchAuthority record, @Param("example") WatchAuthorityExample example);

    int updateByPrimaryKeySelective(WatchAuthority record);

    int updateByPrimaryKey(WatchAuthority record);
}