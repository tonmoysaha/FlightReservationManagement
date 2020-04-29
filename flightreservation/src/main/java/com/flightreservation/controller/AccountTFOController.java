package com.flightreservation.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flightreservation.entity.TotpCodeDto;
import com.flightreservation.exception.InvalidTOTPVerificationCode;
import com.flightreservation.service.TFODetailsService;
import com.flightreservation.service.UserService;

@Controller
public class AccountTFOController {

	@Autowired
	private TFODetailsService tfoService;
	
	
	@GetMapping("/account")
	public String getAccount(Model model, Principal principal) {
		boolean userHasTotpEnabled = tfoService.isTotpEnabled(principal.getName());		
		model.addAttribute("totpEnabled",userHasTotpEnabled);
		return "account";
	}
	
	@GetMapping("/setup-totp")
	public String getGoogleAuthenticatorQRUrl(Model model, Principal principal) {
		boolean userHasTotpEnabled = tfoService.isTotpEnabled(principal.getName());
		if(!userHasTotpEnabled) {
			model.addAttribute("qrUrl",tfoService.generateNewGoogleAuthQrUrl(principal.getName()));
			model.addAttribute("codeDto", new TotpCodeDto());
		}
		model.addAttribute("totpEnabled",userHasTotpEnabled);
		return "account";
	}

	@PostMapping("/confirm-totp")
	public String confirmGoogleAuthenticatorSetup(Model model, Principal principal, @ModelAttribute("codeDto") TotpCodeDto codeDto) {
		boolean userHasTotpEnabled = tfoService.isTotpEnabled(principal.getName());
		if(!userHasTotpEnabled) {
			tfoService.enableTFOForUser(principal.getName(), Integer.valueOf(codeDto.getCode()));
			model.addAttribute("totpEnabled",true);
		}
		return "account";
	}
	
	@ExceptionHandler(InvalidTOTPVerificationCode.class)
	public String handleInvalidTOTPVerificationCode(Model model, Principal principal) {
		boolean userHasTotpEnabled = tfoService.isTotpEnabled(principal.getName());
		model.addAttribute("totpEnabled",userHasTotpEnabled);
		model.addAttribute("confirmError",true);
		return "account";
	}


}
