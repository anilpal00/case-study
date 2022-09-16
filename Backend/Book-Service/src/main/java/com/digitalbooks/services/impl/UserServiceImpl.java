package com.digitalbooks.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entities.User;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		return users;
	}

}
