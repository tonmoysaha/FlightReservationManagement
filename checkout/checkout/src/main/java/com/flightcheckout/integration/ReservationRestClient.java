package com.flightcheckout.integration;

import com.flightcheckout.entity.Reservation;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation();
}
