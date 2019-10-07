package com.flightreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/regUser")
	public String useRegs() {
		return "regestrationPage";
	}
}
