package com.digitalbooks.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.dao.BookDto;
import com.digitalbooks.entities.Book;
import com.digitalbooks.entities.User;
import com.digitalbooks.exceptions.ResourceNotFoundException;
import com.digitalbooks.repositories.BookRepo;
import com.digitalbooks.repositories.UserRepo;
import com.digitalbooks.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public BookDto createAuthorBook(BookDto bookDto, Integer userId) {
	
		Book book = this.modelMapper.map(bookDto, Book.class);
		Set<Book> books= new HashSet<>();
		User user1= new User();
		Optional<User> byId= userRepo.findById(userId);	
		
		if(!byId.isPresent()) {
			throw new ResourceNotFoundException("User with id","does not exit", userId);
		}
		
		User user= byId.get();
		book.setUser(user);
		Book book1= bookRepo.save(book);
		books.add(book1);
		user1.setBooks(books);
		return this.modelMapper.map(book1, BookDto.class);
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = this.bookRepo.findAll();
		List<BookDto> bookDto = books.stream().map((book)->this.modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
		return bookDto;
	}
	
	@Override
	public BookDto getBookById(Integer bookId) {
		Optional<Book> book = this.bookRepo.findById(bookId);
		return this.modelMapper.map(book, BookDto.class);
	}

}
