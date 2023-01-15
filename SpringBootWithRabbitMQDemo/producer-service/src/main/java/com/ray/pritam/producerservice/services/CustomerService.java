package com.ray.pritam.producerservice.services;

import com.ray.pritam.producerservice.config.EventProducerConfiguration;
import com.ray.pritam.producerservice.message.CustomMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerService {
    private Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final RabbitTemplate rabbitTemplate;

    public CustomerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void createCustomer(CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        logger.info("Send Data : {} ",message);
        rabbitTemplate.convertAndSend(EventProducerConfiguration.EXCHANGE,EventProducerConfiguration.ROUTING_KEY,message);
    }

}