package com.cognizant.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.bank.model.AppUser;
import com.cognizant.bank.model.CustomerEntity;

@Controller

@SessionAttributes({"empToken","custToken"})
public class LoginController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("empToken", "");
		model.addAttribute("custToken", "");
		return "home";
	}
	
	@GetMapping("/customerlogin")
	public String loginForCustomer(Model model) {
		AppUser user = new AppUser();
		model.addAttribute("user",user);
		model.addAttribute("role","Customer");
		return "login";
	}
	
	@GetMapping("/employeelogin")
	public String loginForEmployee(Model model) {
		AppUser user = new AppUser();
		model.addAttribute("user",user);
		model.addAttribute("role","Employee");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute AppUser user) {
		if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
			return "try";
		}
		return "employee";
	}
	
	@ModelAttribute
	public CustomerEntity getCustomer() {
		return new CustomerEntity();
	}
	
	

}
