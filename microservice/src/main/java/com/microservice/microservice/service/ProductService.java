package com.microservice.microservice.service;

import java.util.List;

import com.microservice.microservice.domain.Product;

public interface ProductService {

    void insertProduct(Product product);

    List<Product> getProducts();


}
