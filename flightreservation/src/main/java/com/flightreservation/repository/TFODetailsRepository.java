package com.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entity.TFODetails;

public interface TFODetailsRepository extends JpaRepository<TFODetails, Long> {

	void deleteByEmail(String username);

	TFODetails findByEmail(String email);

}
