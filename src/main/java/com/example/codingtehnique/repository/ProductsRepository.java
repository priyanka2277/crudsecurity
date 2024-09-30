package com.example.codingtehnique.repository;

import com.example.codingtehnique.MODEL.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long> {
}
