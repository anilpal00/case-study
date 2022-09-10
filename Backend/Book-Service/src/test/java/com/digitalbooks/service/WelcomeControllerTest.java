package com.digitalbooks.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.digitalbooks.controllers.WelcomeController;
import com.digitalbooks.entities.AuthRequest;
import com.digitalbooks.util.JwtUtil;

@ExtendWith(MockitoExtension.class)
public class WelcomeControllerTest {
	@InjectMocks
	    private WelcomeController welcomeController ;
	    @Mock
	    private  JwtUtil jwtUtil;
	    @Mock
	    private AuthenticationManager authenticationManager;
	    
	    @Autowired
	     MockMvc mvc;

	    @Test
	    public void shouldGenerateAuthToken() throws Exception {
	        AuthRequest authRequest= new AuthRequest();
	        authRequest.setPassword("xyz");
	        authRequest.setUserName("anil@gmail.com");
			String token = welcomeController.generateToken(authRequest);
			//mvc.perform(get("/authenticate")).andDo(print()).andExpect(status().isOk());
			
//("springuser").password("spring123")).andExpect(authenticated());
	    }

}
