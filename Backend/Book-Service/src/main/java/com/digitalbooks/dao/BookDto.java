package com.digitalbooks.dao;

import java.sql.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digitalbooks.entities.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {

	private Integer bookId;
	private String bookImage;
	private String bookTitle;
	private String bookCategory;
	private Double bookPrice;
	private User id;
	private String bookPublisher;
	private Date bookPublisherDate;
	private Integer bookChapters;
	
	@ColumnDefault("0")
	private Integer bookStatus;
	
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;
	
}
