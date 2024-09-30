package com.example.codingtehnique.service;

import com.example.codingtehnique.MODEL.Product;
import com.example.codingtehnique.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Product> getAllProducts(){
        return productsRepository.findAll();

    }
    @Override
    public Product saveProduct(Product product){
        return productsRepository.save(product);
    }
    @Override
    public Optional<Product> getProductById(long id){
        return productsRepository.findById(id);
    }
    @Override
    public Product updateProduct(Product product){
        return productsRepository.save(product);
    }
    @Override
    public void deleteProduct(long id){
        productsRepository.deleteById(id);
    }


}
