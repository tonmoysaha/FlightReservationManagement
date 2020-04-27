package com.flightreservation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.flightreservation.entity.User;

public class PasswoedConfirmedValidator implements ConstraintValidator<PasswoedConfirmed, Object>{

	@Override
	public boolean isValid(Object user, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		String password = ((User)user).getPassword();
		String confirmPassword = ((User)user).getConfirmPassword();
		return password.equals(confirmPassword);
	}

}
