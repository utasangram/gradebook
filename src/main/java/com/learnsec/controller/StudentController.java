package com.learnsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnsec.Student;
import com.learnsec.DAO.StudentDAO;

@Controller
public class StudentController {
	
	@Autowired
	StudentDAO sdao;
	
	@RequestMapping("/")
	public String home(){
		return "home.jsp";
	}
	@RequestMapping("/addStudent")
	public String addStudent(Student student){
		sdao.save(student);
		return "home.jsp";
	}
}
