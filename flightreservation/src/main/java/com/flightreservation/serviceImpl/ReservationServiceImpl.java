package com.flightreservation.serviceImpl;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;

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
import com.flightreservation.utill.EmailUtill;
import com.flightreservation.utill.PDFGenerator;
import com.itextpdf.text.DocumentException;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private PDFGenerator pDFGenerator;
	
	@Autowired
	private EmailUtill emailUtill;

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
		
		String filePath = "E:/reservations/reservation"+ savedPassenger.getId()+".pdf";
		
			try {
				pDFGenerator.generateItinerary(savedReservation, filePath);
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				emailUtill.mailUtinary(passenger.getEmail(), filePath);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return savedReservation;
	}

}
