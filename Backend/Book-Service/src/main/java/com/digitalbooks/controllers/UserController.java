package com.digitalbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entities.User;
import com.digitalbooks.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/digitalbooks")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/allauthors")
	public ResponseEntity<List<User>> getAllAuthors(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
}
