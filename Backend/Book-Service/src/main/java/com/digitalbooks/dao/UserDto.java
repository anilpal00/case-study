package com.digitalbooks.dao;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.digitalbooks.entities.Book;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDto {

	private Integer id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String phone;
	
	private String address;
	
	private Set<Book> books = new HashSet<>();

	private boolean active;
	private String role = "ROLE_AUTHOR";
	
	@CreationTimestamp
    private Date createTime;
	
	
	
}
