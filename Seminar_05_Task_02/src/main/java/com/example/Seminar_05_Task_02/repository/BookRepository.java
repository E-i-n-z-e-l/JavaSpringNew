package com.example.Seminar_05_Task_02.repository;

import com.example.Seminar_05_Task_02.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
