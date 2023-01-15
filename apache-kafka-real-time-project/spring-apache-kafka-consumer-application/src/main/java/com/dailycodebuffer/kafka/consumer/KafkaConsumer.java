package com.dailycodebuffer.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info(String.format("Event message receive %S ", message));
    }
}
