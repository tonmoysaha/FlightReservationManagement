package com.flightreservation.event;

import org.springframework.context.ApplicationEvent;

import com.flightreservation.entity.User;

public class UserRegistrationEvent extends ApplicationEvent {

	private User user;
	
	public UserRegistrationEvent(User user) {
		super(user);
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
