package com.digitalbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.dao.BookDto;
import com.digitalbooks.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/author/{authorId}/books")
	public ResponseEntity<BookDto> createAuthorBook(@RequestBody BookDto bookDto, @PathVariable Integer authorId){
		BookDto createBookDto = this.bookService.createAuthorBook(bookDto, authorId);
		return new ResponseEntity<>(createBookDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getAllBooks(){
		return ResponseEntity.ok(this.bookService.getAllBooks());
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<BookDto> getSingleBook(@PathVariable Integer bookId) {
		return ResponseEntity.ok(this.bookService.getBookById(bookId));
	}
	
//	@PutMapping("/book/{userId}")
//	public ResponseEntity<BookDto> updatebook(@RequestBody BookDto bookDto, @PathVariable Integer userId){
//		return 
//	}
	
}
