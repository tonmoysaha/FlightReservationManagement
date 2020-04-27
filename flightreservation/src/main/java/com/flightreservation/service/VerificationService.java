package com.flightreservation.service;

import com.flightreservation.entity.User;
import com.flightreservation.entity.Verification;

public interface VerificationService {

	Verification createVerification(User user);
	String getEmailForId(String id);

}
