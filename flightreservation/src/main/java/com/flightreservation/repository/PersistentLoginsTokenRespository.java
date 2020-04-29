package com.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entity.PersistentLoginToken;

public interface PersistentLoginsTokenRespository extends JpaRepository<PersistentLoginToken, Long> {

	PersistentLoginToken findBySeries(String series);

	PersistentLoginToken findByUsername(String username);

}
