package com.sktTask.ProductService;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductServiceApplication {
    static final String EXCHANGE_NAME = "exchange";
    static final String QUEUE_NAME = "queue";
    static final String ROUTING_KEY = "product";

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public TopicExchange productExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Queue defaultParsingQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    Binding queueToExchangeBinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(defaultParsingQueue()).to(productExchange()).with(ROUTING_KEY);
    }

}

