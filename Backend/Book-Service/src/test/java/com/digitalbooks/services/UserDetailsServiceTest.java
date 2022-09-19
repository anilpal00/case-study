package com.digitalbooks.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
	private RoleRepository roleRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private BookRepository bookRepository;
	@InjectMocks
	BookServiceImpl bookServiceImpl ;
	@Test
	void testcreateAuthorBook() {
			Book book = new Book();
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
		
//			Optional<User> user1 = userRepository.findById(1);
//			doReturn(Optional.of(user1)).when(bookRepository).findById(1);
//		bookServiceImpl.getBookById(book.getBookId());
//		bookServiceImpl.createAuthorBook(book, 1);
		
	}
}