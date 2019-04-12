package com.learnsec.DAO;

import org.springframework.data.repository.CrudRepository;

import com.learnsec.Student;

public interface StudentDAO extends CrudRepository<Student, Integer>{
	
}
