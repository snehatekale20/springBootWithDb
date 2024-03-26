package com.springbootwithdb.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.springbootwithdb.entity.Student;

@Configuration
public interface StudentServiceIfc {

	public Student saveStudent(Student st);

	public List<Student> getAllStudent();

	public Student getOneStudent(int rollNo);

	public void deleteStudent(int rollNo);

	public Student updateStudent(Student st1);
	
	public List<Student> getByName(String name);
	
	public List<Student> getResult(String name);


	
}
