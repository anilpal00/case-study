package com.digitalbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entities.AuthRequest;
import com.digitalbooks.util.JwtUtil;

@RestController
@CrossOrigin
public class WelcomeController {

	    @Autowired
	    private JwtUtil jwtUtil;
	    
	    @Autowired
	    private AuthenticationManager authenticationManager;

	  
	    @PostMapping("/authenticate")
	    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName() , authRequest.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid userName/password");
	        }
	        return jwtUtil.generateToken(authRequest.getUserName());
    }
}