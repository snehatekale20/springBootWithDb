package com.springbootwithdb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootwithdb.entity.Student;
import com.springbootwithdb.exceptionHandler.RecordNotFoundCustomeExp;
import com.springbootwithdb.service.StudentServiceIfc;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentServiceIfc studentServiceifc;
	
	
	//to get the values of properties from application.properties
	@Value("${aws.username}")
	private String userName;
	@Value("${aws.pwd}")
	private String password;
	
	
	@PostMapping("/save")
	private Student saveStudent(@RequestBody Student st) {
		studentServiceifc.saveStudent(st);
		return st;
	}
	
	@GetMapping("/get")
	private List<Student> getStudent(){
		//this will pring this line after we hit this /get from ui
		logger.trace("this is trace logger");
		logger.debug("this is debug logger");
		logger.error("this is error logger");
		logger.warn("this is warning logger");
		logger.info("this is info logger");
		logger.info("AWS uname : {}  Pwd : {} ",userName ,password);
		return studentServiceifc.getAllStudent();
	}
	
	@GetMapping("/getone")
	private Student getOneStudent(@RequestParam int rollNo) throws RecordNotFoundCustomeExp {
		return studentServiceifc.getOneStudent(rollNo);
	}
	
	@DeleteMapping("/delete")
	private String deleteStudent(@RequestParam int rollNo) {
		studentServiceifc.deleteStudent(rollNo);
		return "student deleted";
	}
	
	@PutMapping("/update")
	private Student updateStud(@RequestBody Student st1) {
		return studentServiceifc.updateStudent(st1);
	}
	
	@GetMapping("/get/{name}")
	private List<Student> getStudentbyname(@PathVariable String name){
		//return studentServiceifc.getByName(name);
		return studentServiceifc.getResult(name);
	}

}
