package com.flightreservation.serviceImpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.entity.Role;
import com.flightreservation.entity.User;
import com.flightreservation.repository.RoleRepository;
import com.flightreservation.repository.UserRepository;
import com.flightreservation.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(User user, Set<Role> roles) {
		// TODO Auto-generated method stub
		User localUser = userRepository.findByEmail(user.getEmail());
		
		if (localUser != null) {
			Logger.info("user already exists");
		}else {
			for (Role role : roles) {
				roleRepository.save(role);
			}
			user.getRoles().addAll(roles);
			userRepository.save(user);
			
		}
		
		
	}

	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	
	

	

}
