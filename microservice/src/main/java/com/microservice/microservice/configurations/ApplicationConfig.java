package com.microservice.microservice.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    public static final String EXCHANGE_NAME = "exchange";
    public static final String QUEUE_NAME = "queue";
    public static final String ROUTING_KEY = "product";





    @Bean
    public TopicExchange productExchange() {
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
