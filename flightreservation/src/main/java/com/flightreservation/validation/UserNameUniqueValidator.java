package com.flightreservation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flightreservation.repository.UserRepository;
public class UserNameUniqueValidator implements ConstraintValidator<UniqueUserName, String> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return userName != null && this.userRepository.findByUserName(userName) == null;
	}

}
