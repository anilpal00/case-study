package com.digitalbooks.entities;

import java.math.BigDecimal;
import java.sql.Date;

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

import lombok.Data;

@Entity
@Data
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	private String bookImage;
	private String bookTitle;
	private String bookCategory;
	private BigDecimal bookPrice;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private User user;
	
	private String bookPublisher;
	
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
