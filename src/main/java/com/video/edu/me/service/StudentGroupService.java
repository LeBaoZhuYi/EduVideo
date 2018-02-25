package com.video.edu.me.service;

import com.video.edu.me.dao.StudentGroupMapper;
import com.video.edu.me.entity.StudentGroup;
import com.video.edu.me.entity.StudentGroupExample;
import com.video.edu.me.enumeration.StudentGroupStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentGroupService extends BaseService<StudentGroup, StudentGroupExample> {

	private static final Logger logger = LoggerFactory.getLogger(StudentGroupService.class);

	private StudentGroupMapper studentGroupMapper;

	@Resource
	public void setStudentGroupMapper(StudentGroupMapper studentGroupMapper){
		this.studentGroupMapper = studentGroupMapper;
		super.setBaseDao(studentGroupMapper);
	}
	
	public List<StudentGroup> getAllNotDeletedStudentGroupList(){
		StudentGroupExample studentGroupExample = new StudentGroupExample();
		studentGroupExample.createCriteria().andStatusLessThan(StudentGroupStatus.REMOVED.getId());
		studentGroupExample.setOrderByClause("ctime DESC");
		return studentGroupMapper.selectByExample(studentGroupExample);
	}

	public String getStudentGroupNameById(int studentGroupId){
		StudentGroup studentGroup = studentGroupMapper.selectByPrimaryKey(studentGroupId);
		return studentGroup.getName();
	}

	public boolean create(StudentGroup studentGroup){
		return 1 == studentGroupMapper.insertSelective(studentGroup);
	}
}
