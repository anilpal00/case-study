package com.digitalbooks.dao;

import java.util.HashSet;
import java.util.Set;

import com.digitalbooks.entities.Book;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDto {

	private Integer id;
	
	private String email;
	
	private String password;
	
	private String userName;
	
//	private String phone;
//	
//	private String address;
	
	private Set<Book> books = new HashSet<>();

//	private boolean active;
	private String roles = "ROLE_AUTHOR";
	
//	@CreationTimestamp
//    private Date createTime;
	
	
	
}
