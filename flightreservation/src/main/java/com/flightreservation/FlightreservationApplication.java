package com.flightreservation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.flightreservation.entity.Role;
import com.flightreservation.entity.User;
import com.flightreservation.repository.RoleRepository;
import com.flightreservation.repository.UserRepository;
import com.flightreservation.service.UserService;

@SpringBootApplication
public class FlightreservationApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserService userService;
	

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setUserName("admin");
		user.setPassword(encoder.encode("admin"));
	  
		Role role = new Role();
		role.setRoleId((long) 1);
		role.setRoleName("ADMIN");
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		
		userService.save(user, roles);
		
	
		
		
		
		
	}

}
