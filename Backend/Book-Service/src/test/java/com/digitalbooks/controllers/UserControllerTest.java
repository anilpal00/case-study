package com.digitalbooks.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.digitalbooks.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
	private UserService userService;
	@InjectMocks
	UserController userController ;
	@Test
	void testGetAllAuthors() {
		userController.getAllAuthors();
	}
	
	

}
