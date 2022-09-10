package com.digitalbooks.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(name = "user_name", nullable = false, length = 100)
	private String userName;
	

	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<>();
	
	@Column(name = "roles")
	private String roles = "ROLE_AUTHOR";

	
	public User() {
		
	}
}
