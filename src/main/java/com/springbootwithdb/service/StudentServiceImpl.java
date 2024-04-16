package com.springbootwithdb.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootwithdb.controller.StudentController;
import com.springbootwithdb.entity.Student;
import com.springbootwithdb.exceptionHandler.RecordNotFoundCustomeExp;
import com.springbootwithdb.repository.StudentRepoIfc;

@Service
public class StudentServiceImpl implements StudentServiceIfc{
	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentRepoIfc studRepo;
	
	@Override
	public Student saveStudent(Student st) {
		return studRepo.save(st);
	}
	@Override
	public List<Student> getAllStudent() {
		logger.info("StudentImpl: listofstudent");
		List<Student> st = studRepo.findAll();
		logger.info("all students: "+st);
		return st;
	}
	@Override
	public Student getOneStudent(int rollNo) throws RecordNotFoundCustomeExp {
		Optional<Student> st = studRepo.findById(rollNo);
		if(st.isPresent()) {
		return st.get();
		}else {
			throw new RecordNotFoundCustomeExp("RollNo is not present: "+rollNo);
		}
	}
	@Override
	public void deleteStudent(int rollNo) {
		studRepo.deleteById(rollNo);
		
	}
	@Override
	public Student updateStudent(Student st1) {
		Student st = studRepo.findById(st1.getRollNo()).get();
		
		if(st1.getName()!= null) {
			st.setName(st1.getName());
		}
		if(st1.getAddress()!= null) {
			st.setAddress(st1.getAddress());

		}if(st1.getEmail()!= null) {
			st.setEmail(st1.getEmail());

		}if(st1.getPhoneNo()>0) {
			st.setPhoneNo(st1.getPhoneNo());

		}

		return studRepo.save(st);
		
	}
	
	@Override
	public List<Student> getByName(String name){
		return studRepo.getByName(name);
	}
	@Override
	public List<Student> getResult(String name) {
		return studRepo.getResult(name);
	}

	
	
}
