package com.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation.dto.ReservationUpdateRequest;
import com.flightreservation.entity.Reservation;
import com.flightreservation.repository.ReservationRepository;
import com.flightreservation.serviceImpl.ReservationServiceImpl;

@RestController
public class ReservationRestController {
	
	private static final  Logger Logger = LoggerFactory.getLogger(ReservationRestController.class);
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation getReservation(@PathVariable("id") Long id) {
		Logger.info("inside getReservation( ) for id: "+ id);
		return reservationRepository.findById(id).orElse(null);
		
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Logger.info("inside updateReservation() for : "+ request);
		Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
		reservation.setNumOfBags(request.getNumOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		Logger.info("save update reservation");
		
		return reservationRepository.save(reservation);
		
	}

}
