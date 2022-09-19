package com.digitalbooks.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.digitalbooks.payload.request.LoginRequest;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.security.jwt.JwtUtils;
@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

	@Mock
	AuthenticationManager authenticationManager;
	@Mock
	UserRepository userRepository;
	@Mock
	RoleRepository roleRepository;
	@Mock
	PasswordEncoder encoder;
	@Mock
	JwtUtils jwtUtils;
	@InjectMocks
	AuthController authController;
	@Test
	void testAuthenticateUser() {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setPassword("anil");
		loginRequest.setUsername("anil");
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		String jwt = jwtUtils.generateJwtToken(authentication);
//		System.out.print("=====================Authentication authentication"+jwt);
		//authController.authenticateUser(loginRequest);
		
	}

}
