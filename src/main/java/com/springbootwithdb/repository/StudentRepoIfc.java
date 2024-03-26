package com.springbootwithdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootwithdb.entity.Student;

@Repository
public interface StudentRepoIfc extends JpaRepository<Student, Integer> {

	@Query(value="Select * from Stud_table s where s.name=?1", nativeQuery=true)
	public List<Student> getByName(String name);
	
	@Query(value="select * from Stud_table s where s.name=?1 or s.address=?1 or s.email=?1", nativeQuery = true)
	public List<Student> getResult(String name);
		
	
}
