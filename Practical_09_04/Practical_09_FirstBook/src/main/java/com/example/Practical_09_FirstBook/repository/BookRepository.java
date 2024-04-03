package com.example.Practical_09_FirstBook.repository;

import com.example.Practical_09_FirstBook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
