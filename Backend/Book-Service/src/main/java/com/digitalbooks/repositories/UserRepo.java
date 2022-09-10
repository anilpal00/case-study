package com.digitalbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
//	User findByEmail(String email);
	User findByUserName(String userName);
	//User findByUserName(String username);
	
}
