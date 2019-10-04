package com.flightreservation.repository;

import org.springframework.data.repository.CrudRepository;

import com.flightreservation.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
