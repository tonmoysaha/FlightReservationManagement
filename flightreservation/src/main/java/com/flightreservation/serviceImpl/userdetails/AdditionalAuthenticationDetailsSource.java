package com.flightreservation.serviceImpl.userdetails;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class AdditionalAuthenticationDetailsSource extends WebAuthenticationDetailsSource {

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		// TODO Auto-generated method stub
		return new AdditionalAuthenticationDetails(context);
	}

	
}
