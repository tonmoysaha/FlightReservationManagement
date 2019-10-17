package com.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entity.Flight;
import com.flightreservation.repository.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("form") String form, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap map) {
		List<Flight> flights = flightRepository.findFlights(form, to, departureDate);

		map.addAttribute("flights", flights);
		return "displayFilghts";

	}
}
