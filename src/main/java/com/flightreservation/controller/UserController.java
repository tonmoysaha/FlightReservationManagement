package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightreservation.entity.User;
import com.flightreservation.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/regUser")
	public String useRegs(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "regPage";
	}
	
	@RequestMapping(value = "/registerUser" , method = RequestMethod.POST)
	public String regestrationUser(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login";
		
	}
}
