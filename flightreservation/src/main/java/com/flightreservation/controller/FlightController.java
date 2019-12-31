package com.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final static Logger Logger = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightRepository flightRepository;

	
	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("form") String form, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap map) {
		
		Logger.info("inside findFlights() From: "+form+" to: "+to+" departureDate: "+ departureDate);
		
		List<Flight> flights = flightRepository.findFlights(form, to, departureDate);

		map.addAttribute("flights", flights);
		Logger.info("flights founds are: "+ flights);
		return "displayFilghts";

	}
	
	@RequestMapping("/admin/showaddflight")
	public String showAddFlightPage() {
		return "showAddFlightPage";
		
	}
}
