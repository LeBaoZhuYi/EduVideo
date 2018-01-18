package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.StudentExample;
import com.video.edu.me.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("adminStudentController")
@RequestMapping(value = "/admin/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(Student student){
        Map<String ,Object> res = new HashMap<>();
        try{
            int insertResult = studentService.insertSelective(student);
            if(insertResult == 0){
                res.put("status", 1);
                res.put("msg", "未成功插入数据");
            }
            else{
                res.put("status", 0);
                res.put("msg", "成功啦！");
            }
            res.put("data", insertResult);
        }catch (Exception e){
            logger.error("create error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> find(int id){
        Map<String, Object> res = new HashMap<>();
        try{
            Student findResult = studentService.selectByPrimaryKey(id);
            if(findResult == null){
                res.put("status", 1);
                res.put("msg", "查找失败");
            }else{
                res.put("status", 0);
                res.put("msg", "成功");
            }
            res.put("data", findResult);
        }catch (Exception e){
            logger.error("find error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> delete(int id)  {
        Map<String, Object> res = new HashMap<>();
        try{
            int deleteResult = studentService.deleteByPrimaryKey(id);
            if(deleteResult == 0){
                res.put("status", 1);
                res.put("msg", "删除出错");
            }else{
                res.put("status", 0);
                res.put("msg", "删除成功");
            }
            res.put("data", deleteResult);
        }catch (Exception e){
            logger.error("delete error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> update(Student student) {
        Map<String, Object> res = new HashMap<>();
        try{
            int updateResult = studentService.updateByPrimaryKey(student);
            if(updateResult == 0){
                res.put("status", 1);
                res.put("msg", "更新失败");
            }else{
                res.put("status", 0);
                res.put("msg", "更新成功");
            }
            res.put("data", updateResult);
        }catch (Exception e){
            logger.error("update error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getList(){
        Map<String, Object> res = new HashMap<>();
        try{
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andStudyIdIsNotNull();
            res.put("status", 0);
            res.put("msg", "");
            res.put("data", studentService.selectByExample(studentExample));
        }catch(Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

}

