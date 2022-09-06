package com.digitalbooks.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	
}
