package com.digitalbooks.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	private String bookName;
	private String bookImage;
	private String bookTitle;
	private String bookCategory;
	private Double bookPrice;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private User user;
	
	@ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;
	
	private String bookPublisher;
	
	 @CreationTimestamp
	private Date bookPublisherDate;
	
	private Integer bookChapters;
	
	@ColumnDefault("0")
	private Integer bookStatus;
	
    @CreationTimestamp
    private Date createTime;
    
    @UpdateTimestamp
    private Date updateTime;
	
	public Book() {
		
	}
	
	
}
