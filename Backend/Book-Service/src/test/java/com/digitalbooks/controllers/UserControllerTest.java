package com.digitalbooks.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.digitalbooks.dao.UserDto;
import com.digitalbooks.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	UserService service ;
	
	@InjectMocks
	UserController controller;
	
	@Test
	void testCreateAuthor() {
		
		UserDto userDto = new UserDto();
		userDto.setId(1);
//		userDto.setActive(true);
		userDto.setPassword("test");
		userDto.setRoles("Author");
		userDto.setUserName("Anil");
		
		when(service.createAuthor(userDto)).thenReturn(userDto);
		ResponseEntity<UserDto> savedUser = controller.createAuthor(userDto);
		assertEquals(savedUser.getStatusCodeValue(),201);
		
	}
	
	@Test
	void testGetAllAuthor() {
		List<UserDto> userDtoList = new ArrayList<>();
		UserDto userDto = new UserDto();
		userDto.setId(1);
//		userDto.setActive(true);
		userDto.setPassword("test");
		userDto.setRoles("Author");
		userDto.setUserName("Anil");
		
		userDtoList.add(userDto);
		when(service.getAllUsers()).thenReturn(userDtoList);
		ResponseEntity<List<UserDto>> savedUser = controller.getAllAuthors();
		assertEquals(savedUser.getStatusCodeValue(),200);
		
	}
	
}
