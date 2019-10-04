package com.flightreservation.entity;

import javax.persistence.Entity;

@Entity
public class Reservation extends AbstractEntity {

	
	private boolean checkedIn;
	private int numOfBags;
	private Passenger passenger;
	private Flight flight;



	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumOfBags() {
		return numOfBags;
	}

	public void setNumOfBags(int numOfBags) {
		this.numOfBags = numOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
