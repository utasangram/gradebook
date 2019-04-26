package com.learnsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


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
	public String showStudentPortal(HttpSession session){
		String nextPage;
		String userid = (String)session.getAttribute("user");
		if(userid == null) { //not a valid user/session
			nextPage="redirect:login";
		}else { //session is valid
			nextPage="studentPortal";
		}
		return nextPage;
	}
	
	@RequestMapping(value = "/studentPortal", params="grades", method = RequestMethod.POST)
	public String showGrades(HttpSession session) {
		//do something
		return "studentPortal";
	}
	
	@RequestMapping(value = "/studentPortal", params="logout", method = RequestMethod.POST)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam(value = "username")String username, @RequestParam(value = "password")String password){
		String nextPage;
		if(validateCredentials(username, password, session)) {
			System.out.println("Login successfull!");
			nextPage="redirect:studentPortal";
		}else{
			System.out.println("Login unsuccessfull!");
			nextPage="redirect:login";
		}
		return nextPage;
	}
	
	
	
	
	/*-- Example validate function --*/
	public boolean validateCredentials(String username, String password, HttpSession session) {
		boolean verified = false;
		if(username.equals("javier") && password.equals("abcd")) {
			verified = true;
			session.setAttribute("user", username);
			session.setAttribute("active", true);
		}
		return verified;
	}
}
