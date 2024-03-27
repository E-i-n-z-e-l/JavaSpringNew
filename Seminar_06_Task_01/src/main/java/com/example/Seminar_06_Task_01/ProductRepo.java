package com.example.Seminar_06_Task_01;

import com.example.Seminar_06_Task_01.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Long> {
}