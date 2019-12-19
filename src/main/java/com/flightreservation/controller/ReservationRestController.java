package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation.dto.ReservationUpdateRequest;
import com.flightreservation.entity.Reservation;
import com.flightreservation.repository.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation getReservation(@PathVariable("id") Long id) {
		return reservationRepository.findById(id).orElse(null);
		
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
		reservation.setNumOfBags(request.getNumOfBags());
		reservation.setCheckedIn(request.getCheckdIn());
		
		Reservation updatedReservation = reservationRepository.save(reservation);
		
		return updatedReservation;
		
	}

}
