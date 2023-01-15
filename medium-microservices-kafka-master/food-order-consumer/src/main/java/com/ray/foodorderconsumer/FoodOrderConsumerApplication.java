package com.ray.foodorderconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodOrderConsumerApplication {
    private static final Logger logger = LoggerFactory.getLogger(FoodOrderConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FoodOrderConsumerApplication.class, args);
        logger.info("Running...");
    }

}
