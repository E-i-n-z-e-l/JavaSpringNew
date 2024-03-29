package com.example.Seminar_06_Task_01.service;

import com.example.Seminar_06_Task_01.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Product product);

    Product createProduct(Product product);

    void deleteProduct(Long id);
}
