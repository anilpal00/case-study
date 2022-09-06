package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.dao.BookDto;

public interface BookService {

	BookDto createAuthorBook(BookDto bookDto, Integer authorId);
	List<BookDto> getAllBooks();
	BookDto getBookById(Integer bookId);
}
