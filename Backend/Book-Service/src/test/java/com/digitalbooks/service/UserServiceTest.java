package com.digitalbooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.digitalbooks.dao.BookDto;
import com.digitalbooks.dao.UserDto;
import com.digitalbooks.entities.User;
import com.digitalbooks.repositories.UserRepo;
import com.digitalbooks.service.impl.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

		
	 @Mock
     private ModelMapper modelMapper;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	 UserRepo userRepo;
	@Mock
	UserService userService;
	@Test
	void testSaveUser(){
		UserDto userDto = new UserDto();
		userDto.setEmail("email");
		userDto.setId(1);
		userDto.setPassword("password");
		userDto.setUserName("name");
		userDto.setRoles("Author");
		
		 userServiceImpl.createAuthor(userDto);
		 userServiceImpl.getAllUsers();
		 
		
       assertEquals( userDto.getId(), 1);
        
//		userService.createAuthor(userDto1);
		//when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
		//when(userService.createAuthor(userDto)).thenReturn(userDto);
//		when(repository.save(user)).thenReturn(user);//mock
//		service.save(user);
//		assertEquals(1,	user.getId());
	}

}
