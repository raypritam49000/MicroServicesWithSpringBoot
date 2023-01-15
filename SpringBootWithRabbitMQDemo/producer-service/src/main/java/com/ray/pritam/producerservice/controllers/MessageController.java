package com.ray.pritam.producerservice.controllers;

import com.ray.pritam.producerservice.message.CustomMessage;
import com.ray.pritam.producerservice.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final CustomerService customerService;

    public MessageController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody CustomMessage customMessage) {
        customerService.createCustomer(customMessage);
        return "Message Send it";
    }
}
