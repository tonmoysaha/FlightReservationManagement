package com.flightreservation.utill;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.flightreservation.serviceImpl.ReservationServiceImpl;

@Component
public class EmailUtill {
	
	@Value("${com.email.text}")
	private String emailText;

	@Value("${com.email.subject}")
	private String emailSubject;

	private final static Logger Logger = LoggerFactory.getLogger(EmailUtill.class);
	
	@Autowired
	private JavaMailSender sender;

	public void mailUtinary(String addressTo, String filePath) throws MessagingException {
		
		Logger.info("inside mailUtinary()");
		
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(addressTo);
		helper.setSubject(emailSubject);
		helper.setText(emailText);
		helper.addAttachment("Itinearary", new File(filePath));
		sender.send(message);
	}
}
