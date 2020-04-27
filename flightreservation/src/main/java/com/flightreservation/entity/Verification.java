package com.flightreservation.entity;

import javax.persistence.Entity;

@Entity
public class Verification extends AbstractEntity{

	String verificationId;
	String email;

	
	public String getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
