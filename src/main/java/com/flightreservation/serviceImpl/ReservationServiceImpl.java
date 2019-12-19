package com.flightreservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.entity.Flight;
import com.flightreservation.entity.Passenger;
import com.flightreservation.entity.Reservation;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.repository.PassengerRepository;
import com.flightreservation.repository.ReservationRepository;
import com.flightreservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation BookFlight(ReservationRequest request) {
		// TODO Auto-generated method stub
		
		//make pay
		
		Flight flight = flightRepository.findById(request.getFlightId()).orElse(null);
		
		Passenger passenger= new Passenger();
		passenger.setFristName(request.getPassengerfristName());
		passenger.setMiddleName(request.getPassengermiddleName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerphone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
