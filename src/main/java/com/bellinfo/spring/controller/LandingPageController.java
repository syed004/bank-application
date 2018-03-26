package com.bellinfo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bellinfo.spring.model.LoginCredentials;
import com.bellinfo.spring.model.Student;
import com.bellinfo.spring.service.StudentService;

@Controller
public class LandingPageController {
	@Autowired
	StudentService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingpage(Model model) {
		return "welcome";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loginPage(Model model) {
		LoginCredentials lc = new LoginCredentials();
		model.addAttribute("lc", lc);
		return "register";

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postloginPage(Model model, @ModelAttribute LoginCredentials lc) {
		Student s1 = new Student(lc.getName(), lc.getPassword());
		service.processStudentData(s1);
		System.out.println(lc);
		String text = " Hello: " + lc.getName() + " welcome";
		model.addAttribute("message", text);
		return "sucess";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String registerPage(Model model) {
		LoginCredentials lc1 = new LoginCredentials();
		model.addAttribute("lc1", lc1);
		return "login1";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postregisterPage(Model model, @ModelAttribute LoginCredentials lc1) {
		Student s2 = new Student(lc1.getName(), lc1.getPassword());
		boolean password = service.processStudentvalidation(s2);
		System.out.println(password);
		if (!password) {
			registerPage(model);
			return "login1";
		} else {
			System.out.println(lc1);
			String text = "  " + lc1.toString() + " You are Logged in.";
			model.addAttribute("message", text);
			return "moreinfo";
		}
	}

}
