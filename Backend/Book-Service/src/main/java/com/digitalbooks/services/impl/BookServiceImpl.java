package com.digitalbooks.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entities.Book;
import com.digitalbooks.entities.Role;
import com.digitalbooks.entities.User;
import com.digitalbooks.exceptions.ResourceNotFoundException;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.services.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book createAuthorBook(Book book, Integer id) {

		Role role = roleRepository.findById(1);
		book.setRole(role);
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new ResourceNotFoundException("User with id","does not exit", id);
		}
		
		User user2= user.get();
		book.setUser(user2);		
		Book bookSave = bookRepository.save(book);	
		return bookSave;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = this.bookRepository.findAll();
		//List<Book> bookDto = books.stream().map((book)->book).collect(Collectors.toList());
		return books;
	}

	@Override
	public Book getBookById(Integer bookId) {
//		List<Book> bookObj = new ArrayList<>();
		Book book = this.bookRepository.findById(bookId).get();
		book.setUser(book.getUser());
//		bookObj.add(book1);
		return book;
	}

}
