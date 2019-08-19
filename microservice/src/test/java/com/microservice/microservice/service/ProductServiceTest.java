package com.microservice.microservice.service;

import com.microservice.microservice.configurations.ApplicationConfig;
import com.microservice.microservice.domain.Product;
import com.microservice.microservice.repository.ProductRepository;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {
    private ProductRepository repo ;
    private RabbitTemplate rabbit;
    private ProductService productService;

    @Before
    public void setUp(){
        repo = EasyMock.createMock(ProductRepository.class);
        rabbit= EasyMock.createMock(RabbitTemplate.class);
        productService = new ProductServiceImpl(repo,rabbit);
    }

    @Test
    public void testGetAll(){
        List<Product> products= new ArrayList<>();
        products.add(new Product("mac", "macbook", 200.99));
        products.add(new Product("dell", "Pc", 200.99));
        products.add(new Product("Hp", "Pc", 200.99));
        EasyMock.expect(repo.getProducts()).andReturn(products);

        rabbit.convertAndSend(ApplicationConfig.EXCHANGE_NAME, ApplicationConfig.ROUTING_KEY, products);
        EasyMock.expectLastCall();

        EasyMock.replay(repo, rabbit);

        List<Product> all = productService.getProducts();

        assertEquals(products, all);

        EasyMock.verify(repo, rabbit);

    }
    @Test
    public void testInsertProduct(){
        Product product= new Product("mac", "macbook", 200.99);
        repo.insertProduct(product);
        EasyMock.expectLastCall();
        EasyMock.replay(repo);

        productService.insertProduct(product);

        EasyMock.verify(repo);


    }

}
