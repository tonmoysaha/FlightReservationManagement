package com.flightreservation.serviceImpl.userdetails;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class AdditionalAuthenticationDetails extends WebAuthenticationDetails {

	private String securityPin;
	
	public AdditionalAuthenticationDetails(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		String securityPin = request.getParameter("securityPin");
		this.securityPin = securityPin;
		
	}

	public String getSecurityPin() {
		return securityPin;
	}

	public void setSecurityPin(String securityPin) {
		this.securityPin = securityPin;
	}
	

}
