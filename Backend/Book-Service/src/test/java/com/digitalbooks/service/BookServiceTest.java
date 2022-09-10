package com.digitalbooks.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.digitalbooks.dao.BookDto;
import com.digitalbooks.entities.User;
import com.digitalbooks.exceptions.ResourceNotFoundException;
import com.digitalbooks.repositories.BookRepo;
import com.digitalbooks.repositories.UserRepo;
import com.digitalbooks.service.impl.BookServiceImpl;
import com.digitalbooks.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)

public class BookServiceTest {

	@InjectMocks
	BookServiceImpl bookserviceImp;
	@Mock
	BookService bookService;
	
	//@InjectMocks BookService bookservice = new BookService();

	@Mock
	BookRepo bookRepository;
	@Mock
	User user;
	@Mock
	UserRepo userRepository;
	 @Mock
     private ModelMapper modelMapper;
	 @InjectMocks
		UserServiceImpl userServiceImpl;
		
		@Mock
		 UserRepo userRepo;
	
	@Test
	void testCreateAuthorBook() {
		BookDto bookDto = new BookDto();
		bookDto.setBookCategory("bookCategory");
		bookDto.setBookChapters(1);
		bookDto.setBookImage("jpg");
		bookDto.setBookPrice(200D);
		bookDto.setBookPublisher("bookPublisher");
		bookDto.setBookStatus(1);
		bookDto.setBookTitle("bookTitle");
		User user = new User();
		user.setId(1);
		user.setEmail("test");
		user.setPassword("pass");
		user.setRoles("Author");
		user.setUserName("anil");
		bookDto.setId(user);
		userRepo.save(user);
		//bookserviceImp.createAuthorBook(bookDto, user.getId());
		bookserviceImp.getAllBooks();
		bookserviceImp.getBookById(1);
		ResourceNotFoundException thrown = assertThrows(
				ResourceNotFoundException.class,
		           () -> bookserviceImp.createAuthorBook(bookDto, user.getId()),
		           "User with id does not exit"
		    );

		//bookserviceImp.createAuthorBook(bookDto, user.getId());
		
	}
}
