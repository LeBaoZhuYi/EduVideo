package com.video.edu.me.controller;

import com.video.edu.me.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	private boolean create(Student student) throws IllegalArgumentException, IllegalAccessException {
		return false;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	private Student find(int id) throws IllegalArgumentException, IllegalAccessException {
		return null;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	private boolean delete(int id) throws IllegalArgumentException, IllegalAccessException {
		return false;
	}
}

