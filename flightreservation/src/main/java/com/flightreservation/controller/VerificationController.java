package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entity.User;
import com.flightreservation.service.UserService;
import com.flightreservation.service.VerificationService;

@Controller
public class VerificationController {

	@Autowired
	private VerificationService verificationService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/verify/email")
	public String verifyEmail(@RequestParam String id) {
		String email = verificationService.getEmailForId(id);
		if(email != null) {
			User user = userService.findByEmail(email);
			if (user == null) {
				throw new UsernameNotFoundException("User not found");
			}
			user.setVerified(true);
			userService.updateUser(user);
			return "redirect:/login";
		}
		return "redirect:/registerUser";
	}

}
