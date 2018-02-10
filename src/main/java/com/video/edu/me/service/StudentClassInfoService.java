package com.video.edu.me.service;

import com.video.edu.me.dao.StudentClassInfoMapper;
import com.video.edu.me.entity.StudentClassInfo;
import com.video.edu.me.entity.StudentClassInfoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentClassInfoService extends BaseService<StudentClassInfo, StudentClassInfoExample> {

	private static final Logger logger = LoggerFactory.getLogger(StudentClassInfoService.class);

	private StudentClassInfoMapper studentClassInfoMapper;

	@Resource
	public void setStudentMapper(StudentClassInfoMapper studentClassInfoMapper){
		this.studentClassInfoMapper = studentClassInfoMapper;
		super.setBaseDao(studentClassInfoMapper);
	}
}
