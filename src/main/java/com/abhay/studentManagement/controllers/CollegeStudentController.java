package com.abhay.studentManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.abhay.studentManagement.entities.CollegeStudent;
import com.abhay.studentManagement.repository.CollegeStudentRepository;

@Controller
public class CollegeStudentController {

	@Autowired
	CollegeStudentRepository studentRepository;
	
	
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "student/login";
	}
	

	@RequestMapping(value = "/studentDashbord", method = RequestMethod.POST)
	public String studentDashbord(@RequestParam("rollNumber") int rollNumber, @RequestParam("password") String password,
			ModelMap modelMap) {
		CollegeStudent student = studentRepository.findById(rollNumber).orElse(null);
		System.out.println("Hello Inside DashBord");
		
		String pass=new BCryptPasswordEncoder().encode(password);
		
		
	//	Password p = new Password(new BCryptPasswordEncoder().encode(encodedPw));
		
		

		if (pass.equals(student.getPassword())){
			return "student/studentHome";

		} else {
			modelMap.addAttribute("msg", "Username Or password did not matched");

		}
		return "student/login";

	}

}
