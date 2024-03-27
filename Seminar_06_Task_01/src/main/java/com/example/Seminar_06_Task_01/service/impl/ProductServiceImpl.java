package com.example.Seminar_06_Task_01.service.impl;

import com.example.Seminar_06_Task_01.ProductRepo;
import com.example.Seminar_06_Task_01.model.Product;
import com.example.Seminar_06_Task_01.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productById = getProductById(product.getId());

        /*productById.setCount(product.getCount());*/
        productById.setName(product.getName());
        productById.setQuantity(product.getQuantity());


        return productRepo.save(productById);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product productById = getProductById(id);
        productRepo.delete(productById);
    }
}
