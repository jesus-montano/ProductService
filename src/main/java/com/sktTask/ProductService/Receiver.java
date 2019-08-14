package com.sktTask.ProductService;

import java.util.concurrent.CountDownLatch;

import com.sktTask.ProductService.models.Product;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    @RabbitListener(queues = ProductServiceApplication.QUEUE_NAME)
    public void ReciveMessage(final Product message){
        log.info("recived message", message.toString());
    }

}