package com.flightreservation.repository;

import org.springframework.data.repository.CrudRepository;
import com.flightreservation.entity.Flight;
import com.flightreservation.entity.Reservation;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {


}
