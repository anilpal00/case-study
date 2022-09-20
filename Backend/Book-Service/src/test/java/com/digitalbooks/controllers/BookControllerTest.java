package com.digitalbooks.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.digitalbooks.entities.Book;
import com.digitalbooks.entities.ERole;
import com.digitalbooks.entities.Role;
import com.digitalbooks.entities.User;
import com.digitalbooks.services.BookService;
import com.digitalbooks.services.impl.BookServiceImpl;
@ExtendWith(MockitoExtension.class)
class BookControllerTest {
	@Mock
	private BookService bookService;
	
	@InjectMocks
	BookController bookController;
	@InjectMocks
	BookServiceImpl bookServiceImpl;
	@Mock
	Book book;
	@Test
	void testCreateAuthorBook() {
		//Book book = new Book();
		book.setBookCategory("null");
		book.setBookChapters(1);
		book.setBookId(1);
		book.setBookImage("jpg");
		book.setBookPrice(200D);
		book.setBookPublisher("null");
		book.setBookStatus(1);
		book.setBookTitle("title");
		Role role = new Role();
		role.setId(1);
		role.setName(ERole.ROLE_ADMIN);
		book.setRole(role);
		User user = new User();
		user.setEmail("anil@gmail.com");
		user.setId(1);
		user.setPassword("test");
		Set<Role> roleSet = new HashSet<Role>();
		roleSet.add(role);
		user.setRoles(roleSet);
		book.setUser(user);
		when(bookService.createAuthorBook(book, 1)).thenReturn(book);
		ResponseEntity<Book> savedBook =	bookController.createAuthorBook(book, role.getId());
		bookController.getAllBooks();
		//ResponseEntity<Book> getBookId =bookController.getSingleBook(1);
		bookController.getUserBook(user.getId());
		//bookController.getSingleBook(book.getBookId());
		assertEquals(savedBook.getStatusCodeValue(),201);
		assertEquals(role.getName(),ERole.ROLE_ADMIN);
		
		}

}
