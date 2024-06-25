package com.pavs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pavs.model.User;
import com.pavs.service.Userservice;

import jakarta.persistence.Access;

@RestController
public class UserController {

	
	@Autowired
	private Userservice service;
	
	@PostMapping("register")
	public User register(@RequestBody User user)
	{
		return service.saveUser(user);
	}
}
