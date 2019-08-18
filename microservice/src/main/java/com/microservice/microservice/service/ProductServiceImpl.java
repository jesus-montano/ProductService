package com.microservice.microservice.service;

import java.util.List;

import com.microservice.microservice.configurations.ApplicationConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microservice.domain.Product;
import com.microservice.microservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RabbitTemplate rabbitTemplate) {
        this.productRepository = productRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    @RabbitListener(queues = ApplicationConfig.QUEUE_NAME)
    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.getProducts();
        rabbitTemplate.convertAndSend(ApplicationConfig.EXCHANGE_NAME, ApplicationConfig.ROUTING_KEY, products);
        return products;
    }
}
