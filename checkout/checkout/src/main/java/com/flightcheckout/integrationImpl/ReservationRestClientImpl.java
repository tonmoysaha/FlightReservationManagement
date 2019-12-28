package com.flightcheckout.integrationImpl;

import org.springframework.web.client.RestTemplate;

import com.flightcheckout.dto.ReservationUpdateRequest;
import com.flightcheckout.entity.Reservation;
import com.flightcheckout.integration.ReservationRestClient;

public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION = "http://localhost:8081/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION, Reservation.class, id);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION, request, Reservation.class);
		return reservation;
	}

}
