package com.digitalbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entities.Book;
import com.digitalbooks.services.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
@CrossOrigin(origins="*", maxAge=3600)
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/author/{id}/books")
	public ResponseEntity<Book> createAuthorBook(@RequestBody Book book, @PathVariable Integer id){
		Book createBook = this.bookService.createAuthorBook(book, id);
		return new ResponseEntity<>(createBook, HttpStatus.CREATED);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> book = this.bookService.getAllBooks();
		return ResponseEntity.ok(book);
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getSingleBook(@PathVariable Integer bookId) {
		Book book = this.bookService.getBookById(bookId);
		book.getUser().getId();
		book.getUser().getEmail();
		book.getUser().getPassword();
		book.getUser().getRoles();
		book.getUser().getUsername();
		return  ResponseEntity.ok(book);
	}

}
