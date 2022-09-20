package com.digitalbooks.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.digitalbooks.entities.Book;
import com.digitalbooks.entities.ERole;
import com.digitalbooks.entities.Role;
import com.digitalbooks.entities.User;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.services.impl.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceTest {

	@Mock
	private UserRepository userRepository;
//	@Mock
//	BookRepository bookRepository;
	@InjectMocks
	BookServiceImpl bookServiceImpl ;
	@Test
	void testcreateAuthorBook() {
		userRepository.findAll();
		bookServiceImpl.getAllBooks();
	}
}