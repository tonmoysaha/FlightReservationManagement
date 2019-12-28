package com.flightreservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.flightreservation.entity.Flight;


public interface FlightRepository extends CrudRepository<Flight, Long> {

	@Query("from Flight where departureCity= :departureCity and arrivalCity= :arrivalCity and dateOfDeparture= :dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity")String form,@Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);

}
