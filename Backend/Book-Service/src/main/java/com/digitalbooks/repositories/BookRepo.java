package com.digitalbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
