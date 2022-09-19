package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digitalbooks.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	//@Query(value = "SELECT DISTINCT (b.book_id),b.book_category,b.book_image,b.book_name,b.book_price,b.book_chapters FROM  book b inner join userpurchased u on u.book_id = b.book_id where b.user_id=:userId", nativeQuery = true)
	@Query(value = "SELECT distinct(b.book_id)as id, b.* FROM book b inner join userpurchased u on u.book_id = b.book_id where b.user_id=:userId", nativeQuery = true)	
	String[] findUserBook(@Param("userId") int userId);
}
