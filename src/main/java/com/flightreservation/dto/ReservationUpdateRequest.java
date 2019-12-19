package com.flightreservation.dto;

public class ReservationUpdateRequest {
	
	private Long id;
	private Boolean checkdIn;
	private int numOfBags;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getCheckdIn() {
		return checkdIn;
	}
	public void setCheckdIn(Boolean checkdIn) {
		this.checkdIn = checkdIn;
	}
	public int getNumOfBags() {
		return numOfBags;
	}
	public void setNumOfBags(int numOfBags) {
		this.numOfBags = numOfBags;
	}
	
	
	
	
	
	



}
