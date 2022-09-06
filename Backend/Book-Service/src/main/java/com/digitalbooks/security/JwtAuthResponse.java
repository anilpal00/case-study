package com.digitalbooks.security;

import com.digitalbooks.dao.UserDto;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	private UserDto user;
}
