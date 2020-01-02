package com.flightreservation.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.flightreservation.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	private static final Logger Logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	@Autowired
	private UserSecurityServiceImpl UserSecurityServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	

	@Override
	public boolean login(String username, String password) {
		
		Logger.info("inside login securoty");
		UserDetails userDetails = UserSecurityServiceImpl.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		
		authenticationManager.authenticate(token);
		
		boolean authenticated = token.isAuthenticated();
		
		Logger.info("status" +authenticated);
		
		if (authenticated) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return authenticated;
	}

}
