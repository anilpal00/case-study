package com.digitalbooks.services;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.digitalbooks.entities.Book;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserPurchasedRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.services.impl.BookServiceImpl;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	
	@Mock
	private RoleRepository roleRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private BookRepository bookRepository;

	@Mock
	private UserPurchasedRepository userPurchasedRepository;
	@MockBean
	BookServiceImpl bookServiceImpl ;
	
	Book book;
	@Test
	void testcreateAuthorBook() {
		given(bookRepository.findUserBook(book.getBookId())).willReturn(null);

//given(employeeRepository.save(employee)).willReturn(employee);
//
//System.out.println(employeeRepository);
//System.out.println(employeeService);
	}

}
