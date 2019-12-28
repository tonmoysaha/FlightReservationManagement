package com.flightreservation.repository;

import org.springframework.data.repository.CrudRepository;
import com.flightreservation.entity.Passenger;


public interface PassengerRepository extends CrudRepository<Passenger, Long> {

}
