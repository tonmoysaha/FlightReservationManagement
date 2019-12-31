package com.flightreservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.flightreservation.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private UserSecurityServiceImpl UserSecurityServiceImpl;
	
	private AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) {
		
		UserDetails userDetails = UserSecurityServiceImpl.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password);
		
		authenticationManager.authenticate(token);
		
		boolean authenticated = token.isAuthenticated();
		
		if (authenticated) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return authenticated;
	}

}
