package com.video.edu.me.service;

import com.video.edu.me.dao.StudentGroupMapper;
import com.video.edu.me.entity.StudentGroup;
import com.video.edu.me.entity.StudentGroupExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentGroupService extends BaseService<StudentGroup, StudentGroupExample> {

	private static final Logger logger = LoggerFactory.getLogger(StudentGroupService.class);

	private StudentGroupMapper studentGroupMapper;

	@Resource
	public void setStudentGroupMapper(StudentGroupMapper studentGroupMapper){
		this.studentGroupMapper = studentGroupMapper;
		super.setBaseDao(studentGroupMapper);
	}
}
