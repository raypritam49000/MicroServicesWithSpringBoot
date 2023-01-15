package com.ray.foodorderconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ray.foodorderconsumer.domain.FoodOrder;
import com.ray.foodorderconsumer.dto.FoodOrderDto;
import com.ray.foodorderconsumer.services.FoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    private static final String orderTopic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final FoodOrderService foodOrderService;

    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, FoodOrderService foodOrderService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.foodOrderService = foodOrderService;
    }

    @KafkaListener(topics = orderTopic,groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);
        FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        foodOrderService.persistFoodOrder(foodOrder);
    }

}
