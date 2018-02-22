package com.video.edu.me.service;

import com.video.edu.me.dao.StudentMapper;
import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.StudentExample;
import com.video.edu.me.entity.User;
import com.video.edu.me.enumeration.StudentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService extends BaseService<Student, StudentExample> {

	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

	private StudentMapper studentMapper;

	@Resource
	public void setStudentMapper(StudentMapper studentMapper){
		this.studentMapper = studentMapper;
		super.setBaseDao(studentMapper);
	}

	public Student getStudentByUserId(int userId){
		StudentExample studentExample = new StudentExample();
		studentExample.createCriteria().andUserIdEqualTo(userId);
		return studentMapper.selectByExample(studentExample).get(0);
	}

	public List<Student> getAllNotDeletedStudentList(){
		StudentExample studentExample = new StudentExample();
		studentExample.createCriteria().andStatusLessThan(StudentStatus.REMOVED.getId());
		studentExample.setOrderByClause("ctime DESC");
		return studentMapper.selectByExample(studentExample);
	}
}
