package com.sktTask.ProductService;

import com.sktTask.ProductService.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    private static final Logger log= LoggerFactory.getLogger(Sender.class);
    private final RabbitTemplate rabbitTemplate;


    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Scheduled(fixedDelay = 3000L)
    public void sendProdduct(){
        Product product = new Product("mac","macbook pro", 299.99);
        rabbitTemplate.convertAndSend(ProductServiceApplication.EXCHANGE_NAME, ProductServiceApplication.ROUTING_KEY, product);
        log.info("product sent");
    }
}
