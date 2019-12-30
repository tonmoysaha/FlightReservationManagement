package com.flightreservation.entity;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

	private String fristName;
	private String lastName;
	private String userName;
	private String email;
	private String password;

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [fristName=" + fristName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
