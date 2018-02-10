package com.video.edu.me.dao;

import com.video.edu.me.entity.StudentClassInfo;
import com.video.edu.me.entity.StudentClassInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentClassInfoMapper extends BaseDao<StudentClassInfo, StudentClassInfoExample>{
    int countByExample(StudentClassInfoExample example);

    int deleteByExample(StudentClassInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentClassInfo record);

    int insertSelective(StudentClassInfo record);

    List<StudentClassInfo> selectByExample(StudentClassInfoExample example);

    StudentClassInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentClassInfo record, @Param("example") StudentClassInfoExample example);

    int updateByExample(@Param("record") StudentClassInfo record, @Param("example") StudentClassInfoExample example);

    int updateByPrimaryKeySelective(StudentClassInfo record);

    int updateByPrimaryKey(StudentClassInfo record);
}