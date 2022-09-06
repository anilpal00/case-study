package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.dao.UserDto;

public interface UserService {
	
	UserDto createAuthor(UserDto user);
	
	List<UserDto> getAllUsers();
}
