package com.video.edu.me;

import com.video.edu.me.dao.StudentMapper;
import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.StudentExample;
import com.video.edu.me.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath*: mybatis-config.xml", "classpath:spring-*.xml"})
public class AdminStudentTest {

    @Autowired
    StudentMapper studentMapper;

    /*@Test
    public void testInsert(){
        Student student = new Student();
        student.setStuName("lebao");
        student.setStudyId("201292368");
        int res = studentMapper.insertSelective(student);
        assert res == 1;
    }*/

    /*@Test
    public void testFind(){
        Student student = new Student();
        student.setStuName("bao");
        student.setStudyId("20129236");
        Student res = studentMapper.selectByPrimaryKey(student.getId());
        System.out.println(studentMapper.selectByPrimaryKey(student.getId()));
    }*/

    @Test
    public void testGetlist(){
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudyIdIsNotNull();
        List<Student> res = studentMapper.selectByExample(studentExample);
    }
}
