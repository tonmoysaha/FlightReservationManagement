package com.flightcheckout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightcheckout.entity.Reservation;
import com.flightcheckout.integration.ReservationRestClient;

@Controller
public class FlightCheckinController {
	
	@Autowired
	private ReservationRestClient reservationRestClient;
	
	@RequestMapping("/")
	public String showStartCheckinPage() {
		return "startCheckIn";

	}
	@RequestMapping(value = "/startCheckIn" , method = RequestMethod.POST)
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap map) {
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		map.addAttribute("reservation" , reservation);
		return "dispalyReservationDetails";
		
	}

}
