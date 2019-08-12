package com.sktTask.ProductService.controller;

import com.sktTask.ProductService.models.Product;
import com.sktTask.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
public class ProductController {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @GetMapping("/products")
//    public List<Product> getAllProducts(){
//
//        return productRepository.findAll();
//    }
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable(value="id")Integer productId){
//
//        @Valid @RequestBody
//    }


}
