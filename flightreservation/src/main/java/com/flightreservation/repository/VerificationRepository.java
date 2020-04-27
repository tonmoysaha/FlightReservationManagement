package com.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entity.Verification;

public interface VerificationRepository extends JpaRepository<Verification, Long> {

	Verification findByVerificationId(String id);

}
