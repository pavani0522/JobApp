package com.pavs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pavs.model.User;
import com.pavs.repository.UserRepo;

@Service
public class Userservice {
	@Autowired
	private UserRepo repo;
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(7);
	public User saveUser(User User) {
		User.setPassword(encoder.encode(User.getPassword()));
		return repo.save(User);
		
	}

}
