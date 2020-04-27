package com.flightreservation.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import com.flightreservation.event.UserRegistrationEvent;
import com.flightreservation.repository.UserRepository;
import com.flightreservation.service.SecurityService;
import com.flightreservation.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Value(value = "${disableEmailVerificatio}")
	private boolean disableEmailVerification;

	private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/")
	public String home(Model model) {
		Logger.info("index");
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		Logger.info("loginPage");
		return "login";
	}



	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String regestrationPage(Model model) {
		Logger.info("INSIDE regestrationPage");
		User user = new User();
		model.addAttribute("user", user);
		return "regPage";

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String regestrationUser(@Valid @ModelAttribute("user") User user,
			ModelMap map) {
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		User userExist = userRepository.findByEmail(user.getEmail());
      
		Logger.info("regestrationUser already Exist: " + userExist);
		if (userExist != null) {
			map.addAttribute("userExist", true);
			map.addAttribute("msg", "User already Exist "+ user.getEmail()+"with this email Id");
			return "regPage";
		}
		user.setPassword(encoder.encode(user.getPassword()));
		user.setVerified(disableEmailVerification);
		Role role = new Role();
		role.setRoleId((long) 2);
		role.setRoleName("ROLE_USER");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		userService.save(user, roles);
		applicationEventPublisher.publishEvent(new UserRegistrationEvent(user));
		Logger.info("regestrationUser save Successfully" + user);
		return "regPage";

	}

}
