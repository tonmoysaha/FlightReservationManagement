package com.flightreservation.service;

import java.util.List;

import com.flightreservation.entity.Flight;

public interface FlightService {

	List<Flight> flightList();

	Flight findByFlightId(Long flightId);

	void deleteFlight(Long flightId);

}
