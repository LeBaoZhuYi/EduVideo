package com.video.edu.me.dao;

import com.video.edu.me.entity.StudentGroup;
import com.video.edu.me.entity.StudentGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentGroupMapper extends BaseDao<StudentGroup, StudentGroupExample>{
    int countByExample(StudentGroupExample example);

    int deleteByExample(StudentGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentGroup record);

    int insertSelective(StudentGroup record);

    List<StudentGroup> selectByExampleWithBLOBs(StudentGroupExample example);

    List<StudentGroup> selectByExample(StudentGroupExample example);

    StudentGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentGroup record, @Param("example") StudentGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") StudentGroup record, @Param("example") StudentGroupExample example);

    int updateByExample(@Param("record") StudentGroup record, @Param("example") StudentGroupExample example);

    int updateByPrimaryKeySelective(StudentGroup record);

    int updateByPrimaryKeyWithBLOBs(StudentGroup record);

    int updateByPrimaryKey(StudentGroup record);
}