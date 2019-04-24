package com.learnsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnsec.Student;
import com.learnsec.DAO.StudentDAO;

@Controller
public class StudentController {
	
	@Autowired
	StudentDAO sdao;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	@RequestMapping("/addStudent")
	public String addStudent(Student student){
		sdao.save(student);
		return "home";
	}
	
	@RequestMapping(value = "/studentPortal", method = RequestMethod.GET)
	public String showStudentPortal(){
		return "studentPortal";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password){
		String nextPage;
		if(validateCredentials(username, password)) {
			System.out.println("Login successfull!");
			nextPage="redirect:studentPortal";
		}else{
			System.out.println("Login unsuccessfull!");
			nextPage="redirect:login";
		}
		return nextPage;
	}
	
	
	
	
	/*-- Example validate function --*/
	public boolean validateCredentials(String username, String password) {
		boolean verified = false;
		if(username.equals("javier") && password.equals("abcd")) {
			verified = true;
		}
		return verified;
	}
}
