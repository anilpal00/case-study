package com.digitalbooks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.dao.UserDto;
import com.digitalbooks.entities.User;
import com.digitalbooks.repositories.UserRepo;
import com.digitalbooks.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createAuthor(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User saveUser = this.userRepo.save(user);
		return this.modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDto = users.stream().map((user) -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDto;
	}
	
	
	
	
}
