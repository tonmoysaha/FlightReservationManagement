package com.flightreservation.utill;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtill {
	
	@Autowired
	private JavaMailSender sender;

	public void mailUtinary(String addressTo, String filePath) throws MessagingException {
		
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(addressTo);
		helper.setSubject("Itinearary for your flight");
		helper.setText("Please find your Attachment Here");
		helper.addAttachment("Itinearary", new File(filePath));
		sender.send(message);
	}
}
