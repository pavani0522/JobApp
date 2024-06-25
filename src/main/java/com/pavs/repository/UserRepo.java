package com.pavs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavs.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User  findByUsername(String username);

}
