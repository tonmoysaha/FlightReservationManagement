package com.flightreservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightreservation.entity.TFODetails;
import com.flightreservation.entity.User;
import com.flightreservation.exception.InvalidTOTPVerificationCode;
import com.flightreservation.repository.TFODetailsRepository;
import com.flightreservation.repository.UserRepository;
import com.flightreservation.service.TFODetailsService;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

public class TFODetailsServiceImpl implements TFODetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TFODetailsRepository tfoDetailsRepository;
	
	private final GoogleAuthenticator googleAuth = new GoogleAuthenticator();
	
	private static final String ISSUER = "";

	
	@Override
	public boolean isTotpEnabled(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email).isTfoEnable();
	}
	@Override
	public String generateNewGoogleAuthQrUrl(String email) {	
		GoogleAuthenticatorKey authKey = googleAuth.createCredentials();
		String secret = authKey.getKey();
		tfoDetailsRepository.deleteByEmail(email);
		tfoDetailsRepository.save(new TFODetails(email, secret));
		return GoogleAuthenticatorQRGenerator.getOtpAuthURL(ISSUER, email, authKey);
	}

	@Override
	public void enableTFOForUser(String email, int code) {
		if(!verifyCode(email, code)) {
			throw new InvalidTOTPVerificationCode("Verification code is Invalid");
		}
		User user = userRepository.findByEmail(email);
		user.setTfoEnable(true);
		userRepository.save(user);
	}
	
	@Override
	public boolean verifyCode(String email, int code) {
		TFODetails totpDetails = tfoDetailsRepository.findByEmail(email);
		return googleAuth.authorize(totpDetails.getSecret(), code);
	}


}
