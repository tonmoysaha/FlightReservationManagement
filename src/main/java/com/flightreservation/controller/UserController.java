package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entity.User;
import com.flightreservation.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String useRegs(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model map) {
		User user = userRepository.findByEmail(email);
		if (user.getPassword().equals(password)) {
			return "index";
		} else {
			map.addAttribute("error", true);
			return "login";
		}

	}

	@RequestMapping(value = "/regUser" , method = RequestMethod.GET)
	public String regestrationPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "regPage";

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String regestrationUser(@RequestParam("email") String email, @ModelAttribute("user") User user,
			ModelMap map) {
		User userExist = userRepository.findByEmail(email);
		if (userExist != null) {
			map.addAttribute("userExist",true);
			return "regPage";
		}
		userRepository.save(user);
		return "login";

	}

	
}
