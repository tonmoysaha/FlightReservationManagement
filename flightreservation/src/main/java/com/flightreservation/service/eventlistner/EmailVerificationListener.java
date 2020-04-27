package com.flightreservation.service.eventlistner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.flightreservation.entity.AbstractEntity;
import com.flightreservation.entity.User;
import com.flightreservation.entity.Verification;
import com.flightreservation.event.UserRegistrationEvent;
import com.flightreservation.service.VerificationService;

@Service
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VerificationService verificationService;
	
	@Value(value = "${disableEmailVerificatio}")
	private boolean disableEmailVerification;

	@Override
	public void onApplicationEvent(UserRegistrationEvent event) {

		if(disableEmailVerification) {
			return;
		}
		User user = event.getUser();
		Verification verification = verificationService.createVerification(user);		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Crypto Portfolio Account Verification");
		message.setText("Account activation link: http://localhost:8082/flightreservation/verify/email?id="+verification.getVerificationId());
		message.setTo(verification.getEmail());
		mailSender.send(message);


	}

}
