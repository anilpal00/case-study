package com.digitalbooks.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.dao.UserDto;
import com.digitalbooks.service.UserService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/author/signup")
	public ResponseEntity<UserDto> createAuthor(@RequestBody UserDto userDto){
		UserDto createAuthorDto = this.userService.createAuthor(userDto);
		return new ResponseEntity<>(createAuthorDto, HttpStatus.CREATED);
	}

	@GetMapping("/allauthors")
	public ResponseEntity<List<UserDto>> getAllAuthors(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
}
