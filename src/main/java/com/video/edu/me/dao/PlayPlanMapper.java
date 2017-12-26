package com.video.edu.me.dao;

import com.video.edu.me.entity.PlayPlan;
import com.video.edu.me.entity.PlayPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayPlanMapper extends BaseDao<PlayPlan, PlayPlanExample>{
    int countByExample(PlayPlanExample example);

    int deleteByExample(PlayPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlayPlan record);

    int insertSelective(PlayPlan record);

    List<PlayPlan> selectByExample(PlayPlanExample example);

    PlayPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlayPlan record, @Param("example") PlayPlanExample example);

    int updateByExample(@Param("record") PlayPlan record, @Param("example") PlayPlanExample example);

    int updateByPrimaryKeySelective(PlayPlan record);

    int updateByPrimaryKey(PlayPlan record);
}