package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
