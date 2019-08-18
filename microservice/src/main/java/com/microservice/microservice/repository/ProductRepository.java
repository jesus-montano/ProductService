package com.microservice.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.microservice.microservice.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Procedure("{call insertProduct}")
    void insertProduct(Product product);

    @Procedure("{call getAll}")
    List<Product> getProducts();


}
