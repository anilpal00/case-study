package com.digitalbooks.services;

import java.util.List;

import com.digitalbooks.entities.Book;
import com.digitalbooks.entities.Userpurchased;

public interface BookService {
	
	Book createAuthorBook(Book book, Integer id);
	List<Book> getAllBooks();
	Book getBookById(Integer bookId);
	Userpurchased purchOrderDataSave(Integer bookId, Integer UserId);
	String[] getUserBook(Integer userId);
}
