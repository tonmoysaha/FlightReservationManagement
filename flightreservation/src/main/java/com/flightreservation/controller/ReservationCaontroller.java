package com.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.entity.Flight;
import com.flightreservation.entity.Reservation;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.service.ReservationService;

@Controller
public class ReservationCaontroller {
	
	private static final  Logger Logger = LoggerFactory.getLogger(ReservationCaontroller.class);
	
    @Autowired
	private FlightRepository flightRepository;
    
    @Autowired
    private ReservationService reservationService;
    
	@RequestMapping("/showcompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap map) {
		Logger.info("showCompleteReservation() invoked eith flightId: "+ flightId);
        Flight flight = flightRepository.findById(flightId).orElse(null);
        map.addAttribute("flight", flight);
        Logger.info("Flight is: "+flight);
		return "completereservation";

	}
	@RequestMapping(value = "/completeReservation" , method = RequestMethod.POST)
	public String CompleteReservation(ReservationRequest request, ModelMap modelMap) {
		Logger.info("CompleteReservation: "+ request);
		Reservation reservation = reservationService.BookFlight(request);
		modelMap.addAttribute("msg", "Reservation completed Successfully " + reservation.getId());
		return "reservationConfirmation";
		
	}
}
