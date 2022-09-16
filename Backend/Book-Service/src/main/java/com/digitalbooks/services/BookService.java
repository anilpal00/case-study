package com.digitalbooks.services;

import java.util.List;

import com.digitalbooks.entities.Book;

public interface BookService {
	
	Book createAuthorBook(Book book, Integer id);
	List<Book> getAllBooks();
	Book getBookById(Integer bookId);
	
}
