package com.flightreservation.repository;

import org.springframework.data.repository.CrudRepository;
import com.flightreservation.entity.Flight;


public interface FlightRepository extends CrudRepository<Flight, Long> {

}
