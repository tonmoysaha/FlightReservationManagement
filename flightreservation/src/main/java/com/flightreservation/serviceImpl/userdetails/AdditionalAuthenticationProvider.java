package com.flightreservation.serviceImpl.userdetails;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flightreservation.entity.User;

@Component
public class AdditionalAuthenticationProvider extends DaoAuthenticationProvider {


	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		super.additionalAuthenticationChecks(userDetails, authentication);
		
		AdditionalAuthenticationDetails details = (AdditionalAuthenticationDetails) authentication.getDetails();
		User user = (User) authentication.getPrincipal();
		if(!getPasswordEncoder().matches(details.getSecurityPin(), user.getSecurityPin())) {
			throw new BadCredentialsException("Invalid security pin");
		}
		user.setSecurityPin(null);
	
}

	@Override
	@Autowired
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		// TODO Auto-generated method stub
		super.setUserDetailsService(userDetailsService);
	}

	@Override
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		// TODO Auto-generated method stub
		super.setPasswordEncoder(passwordEncoder);
	}

}
