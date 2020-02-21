package com.flightreservation.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entity.Flight;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.service.FlightService;

@Controller
public class FlightController {

	private final static Logger Logger = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private FlightService flightService;

	@GetMapping("/findFlights")
	public String findFlightPage() {
		return "findFlights";

	}

	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("form") String form, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate, ModelMap map) {

		Logger.info("inside findFlights() From: " + form + " to: " + to + " departureDate: " + departureDate);

		List<Flight> flights = flightRepository.findFlights(form, to, departureDate);

		map.addAttribute("flights", flights);
		Logger.info("flights founds are: " + flights);
		return "displayFilghts";

	}

	@RequestMapping("/admin/showaddflight")
	public String showAddFlightPage(Model model) {
		Flight flight = new Flight();
		model.addAttribute("flight", flight);
		return "showAddFlightPage";

	}
	
	@RequestMapping("/admin/flightlist")
	public String flightList(ModelMap map) {
		List<Flight> flightList = flightService.flightList();
		map.addAttribute("flightList", flightList);
		return "flightDashBoard";
	}

	@PostMapping("/admin/addFlight")
	public String addFlights(@ModelAttribute("flight") Flight flight,@RequestParam("dateOfDepartures") String date) throws ParseException {
	    //same format with jquery formate with defferent version in java for java or jquery for jquery
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
	    flight.setDateOfDeparture(date1);
	  
		flightRepository.save(flight);

		return "redirect:/admin/flightlist";

	}
	
	@RequestMapping("/admin/updateFlight")
	public String updateFlight(@RequestParam("id") Long flightId, ModelMap map) {
		Flight flight = flightService.findByFlightId(flightId);
		map.addAttribute("flight", flight);
		return "showAddFlightPage";
		
	}

	
	@RequestMapping("/admin/deleteFlight")
	public String deleteFlight(@RequestParam("id") Long flightId) {
	     flightService.deleteFlight(flightId);
		return "redirect:/admin/flightlist";
	     
		
	}
	 
}
