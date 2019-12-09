package com.flightreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entity.Flight;
import com.flightreservation.repository.FlightRepository;

@Controller
public class ReservationCaontroller {

	private FlightRepository flightRepository;
	@RequestMapping("/showcompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap map) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        map.addAttribute("flight", flight);
		return "completereservation";

	}
}
