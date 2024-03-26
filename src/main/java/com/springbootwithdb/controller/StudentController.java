package com.springbootwithdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.springbootwithdb.service.StudentServiceIfc;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentServiceIfc studentServiceifc;
	
	@PostMapping("/save")
	private Student saveStudent(@RequestBody Student st) {
		studentServiceifc.saveStudent(st);
		return st;
	}
	
	@GetMapping("/get")
	private List<Student> getStudent(){
		return studentServiceifc.getAllStudent();
	}
	
	@GetMapping("/getone")
	private Student getOneStudent(@RequestParam int rollNo) {
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
