package com.digitalbooks.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.digitalbooks.dao.BookDto;
import com.digitalbooks.dao.UserDto;
import com.digitalbooks.entities.Book;
import com.digitalbooks.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	@Mock
	BookService service;
	
	@InjectMocks
	BookController controller;
	
	BookDto bookDto = new BookDto();
	Integer authorId;
	
	@BeforeEach
	void setup() {
				
		bookDto.setBookImage("ttttttttt.jpeg");
		bookDto.setBookTitle("xyz");
		bookDto.setBookCategory("xyz");
		bookDto.setBookPrice(8889.90);
		bookDto.setBookPublisher("xyz");
		bookDto.setBookChapters(1);
		bookDto.setBookStatus(1);
		authorId = 1;
	}
	
	@Test
	void testCreateAuthorBook() {	
		when(service.createAuthorBook(bookDto, authorId)).thenReturn(bookDto);
		ResponseEntity<BookDto> savedBook = controller.createAuthorBook(bookDto, authorId);
		assertEquals(savedBook.getStatusCodeValue(),201);
	}
	
	@Test
	void testGetAllBooks() {
		
		List<BookDto> bookDtoList = new ArrayList<>();
		bookDtoList.add(bookDto);
		when(service.getAllBooks()).thenReturn(bookDtoList);
		ResponseEntity<List<BookDto>> getbooks = controller.getAllBooks();
		assertEquals(getbooks.getStatusCodeValue(),200);
	}
	
	@Test
	void testGetSingleBook() {
		bookDto.setBookId(1);
		when(service.getBookById(bookDto.getBookId())).thenReturn(bookDto);
		ResponseEntity<BookDto> getbooks = controller.getSingleBook(bookDto.getBookId());
		assertEquals(getbooks.getStatusCodeValue(),200);
	}
	
}
