package com.example.codingtehnique.service;

import com.example.codingtehnique.MODEL.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Optional<Product>  getProductById(long id);
    Product updateProduct(Product product);
    void deleteProduct(long id);
}
