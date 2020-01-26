package com.flightreservation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.entity.Flight;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Flight> flightList() {
		// TODO Auto-generated method stub
		return (List<Flight>) flightRepository.findAll();
	}

}
