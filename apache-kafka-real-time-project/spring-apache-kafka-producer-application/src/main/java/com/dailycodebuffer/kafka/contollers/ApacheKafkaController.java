package com.dailycodebuffer.kafka.contollers;

import com.dailycodebuffer.kafka.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApacheKafkaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApacheKafkaController.class);

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;
    private static final String TOPIC = "NewTopic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book){
        LOGGER.info(String.format("Event Message Produce : %s",book));
        this.kafkaTemplate.send(TOPIC,book);
        return "Published Successfully";
    }

}
