package com.digitalbooks.entities;

import java.sql.Date;
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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(name = "user_name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "active")
	private boolean active;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<>();
	
	@Column(name = "role")
	private String role = "ROLE_AUTHOR";
	
	@Column(name = "create_time")
	@CreationTimestamp
    private Date createTime;
	
	public User() {
		
	}
}
