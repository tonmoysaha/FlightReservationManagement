package com.flightreservation.service;

import java.util.Set;

import com.flightreservation.entity.Role;
import com.flightreservation.entity.User;

public interface UserService {
	void save(User user, Set<Role> roles);

}
