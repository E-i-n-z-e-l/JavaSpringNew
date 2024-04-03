package com.example.Practical_09_SecondBook.repository;


import com.example.Practical_09_SecondBook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
