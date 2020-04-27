package com.flightreservation.serviceImpl;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.entity.User;
import com.flightreservation.entity.Verification;
import com.flightreservation.repository.VerificationRepository;
import com.flightreservation.service.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

	@Autowired
	private VerificationRepository verificationRepository;
	
	@Override
	public Verification createVerification(User user) {
		// TODO Auto-generated method stubre
		SecureRandom secureRandom = new SecureRandom();
		int Id = secureRandom.nextInt(999999);
		String verificationId = String.valueOf(Id);
		
		Verification verification = new Verification();
		verification.setEmail(user.getEmail());
		verification.setVerificationId(verificationId);
		
		return this.verificationRepository.save(verification);
	}

	@Override
	public String getEmailForId(String id) {
		// TODO Auto-generated method stub
		 Verification findByVerificationId = this.verificationRepository.findByVerificationId(id);
		return findByVerificationId.getEmail();
		 
	}

}
