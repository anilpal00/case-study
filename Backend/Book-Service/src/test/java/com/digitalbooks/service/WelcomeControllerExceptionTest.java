package com.digitalbooks.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;

import com.digitalbooks.controllers.WelcomeController;
import com.digitalbooks.entities.AuthRequest;
import com.digitalbooks.exceptions.ResourceNotFoundException;
import com.digitalbooks.util.JwtUtil;
@ExtendWith(MockitoExtension.class)
public class WelcomeControllerExceptionTest {
	@InjectMocks
    private WelcomeController welcomeController ;
    @Mock
    private  JwtUtil jwtUtil;
   
    private AuthenticationManager authenticationManager;
    
    @Autowired
     MockMvc mvc;

    @Test
    public void shouldGenerateAuthToken() throws Exception {
        AuthRequest authRequest= new AuthRequest();
        authRequest.setPassword("xyz");
        authRequest.setUserName("anil@gmail.com");
		//String token = welcomeController.generateToken(authRequest);
		Exception thrown = assertThrows(
				Exception.class,
		           () -> welcomeController.generateToken(authRequest),
		           "User with id does not exit"
		    );
}
}