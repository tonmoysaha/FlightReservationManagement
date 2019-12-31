package com.flightreservation.serviceImpl;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${com.flightreservation.pdf.generatorlocation}")
	private  String Itenearary_DIR = "E:/reservations/reservation";

	private static final  Logger Logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
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
		
		Logger.info("inside BookFlight()");
		
		Flight flight = flightRepository.findById(request.getFlightId()).orElse(null);
		Logger.info("Flight Found: "+ flight);

		
		Passenger passenger= new Passenger();
		passenger.setFristName(request.getPassengerfristName());
		passenger.setMiddleName(request.getPassengermiddleName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerphone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		Logger.info("Passenger save: "+ savedPassenger);
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		Logger.info("save the reservation: "+ savedReservation);
		
		String filePath = Itenearary_DIR + savedPassenger.getId()+".pdf";
		Logger.info("generating  the Iteniary ");
			try {
				pDFGenerator.generateItinerary(savedReservation, filePath);
				Logger.info("sending  the Iteniary");
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				Logger.error("Problem in generating itenearay"+e);
			}
			
			try {
				emailUtill.mailUtinary(passenger.getEmail(), filePath);
				Logger.info("sending  the email ");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				Logger.error("Exception Sending iteniary: "+ e);
			}
		
		
		return savedReservation;
	}

}
