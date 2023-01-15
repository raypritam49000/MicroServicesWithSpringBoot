package com.ray.pritam.consumer.service.consumer;

import com.ray.pritam.consumer.service.config.EventConsumerConfiguration;
import com.ray.pritam.consumer.service.message.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {
    private Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @RabbitListener(queues = EventConsumerConfiguration.QUEUE)
    public void receive(CustomMessage message) {
        logger.info("Received Data : {}", message);
    }

}