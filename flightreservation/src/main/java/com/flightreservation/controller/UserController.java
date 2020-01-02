package com.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entity.Role;
import com.flightreservation.entity.User;
import com.flightreservation.repository.UserRepository;
import com.flightreservation.service.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService securityService;

	private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/")
	public String loginPage(Model model) {
		Logger.info("loginPage");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model map) {

		Logger.info("login user " + email);

		boolean loginResponse = securityService.login(email, password);
		
		if (loginResponse) {
			Logger.info("login successfully");
			return "index";
		} else {
			map.addAttribute("error", true);
			return "login";
		}

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String regestrationPage(Model model) {
		Logger.info("INSIDE regestrationPage");
		User user = new User();
		model.addAttribute("user", user);
		return "regPage";

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String regestrationUser(@RequestParam("email") String email, @ModelAttribute("user") User user,
			ModelMap map) {
        
		User userExist = userRepository.findByEmail(email);
		Logger.info("regestrationUser already Exist: " + userExist);
		if (userExist != null) {
			map.addAttribute("userExist", true);
			return "regPage";
		}
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		Logger.info("regestrationUser save Successfully" + user);
		return "login";

	}

}
