package com.video.edu.me.service;

import com.video.edu.me.dao.StudentClassInfoMapper;
import com.video.edu.me.entity.StudentClassInfo;
import com.video.edu.me.entity.StudentClassInfoExample;
import com.video.edu.me.enumeration.StudentClassInfoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentClassInfoService extends BaseService<StudentClassInfo, StudentClassInfoExample> {

    private static final Logger logger = LoggerFactory.getLogger(StudentClassInfoService.class);

    private StudentClassInfoMapper studentClassInfoMapper;

    @Resource
    public void setStudentClassInfoMapper(StudentClassInfoMapper studentClassInfoMapper) {
        this.studentClassInfoMapper = studentClassInfoMapper;
        super.setBaseDao(studentClassInfoMapper);
    }

    public StudentClassInfo getLastStudentClassInfoByClassIdAndStudentId(int studentId, int classId) {
        StudentClassInfoExample studentClassInfoExample = new StudentClassInfoExample();
        studentClassInfoExample.createCriteria().andClassIdEqualTo(classId)
                .andStudentIdEqualTo(studentId);
        studentClassInfoExample.setOrderByClause("DESC CTIME");
        List<StudentClassInfo> studentClassInfoList = studentClassInfoMapper.selectByExample(studentClassInfoExample);
        if (studentClassInfoList.size() == 0) {
            return null;
        }
        return studentClassInfoList.get(0);
    }

    public int countFinishedClassTimesByStudentId(int studentId) {
        StudentClassInfoExample studentClassInfoExample = new StudentClassInfoExample();
        studentClassInfoExample.createCriteria().andStudentIdEqualTo(studentId)
                .andStatusEqualTo(StudentClassInfoStatus.END.getId());
        return studentClassInfoMapper.countByExample(studentClassInfoExample);
    }
}