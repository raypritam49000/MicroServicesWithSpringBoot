package net.javaguides.orderservice.controller;

import net.javaguides.basedomains.dto.Order;
import net.javaguides.basedomains.dto.OrderEvent;
import net.javaguides.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        // create order event
        OrderEvent event = new OrderEvent();
        event.setMessage("order status is in pending state");
        event.setStatus("PENDING");
        event.setOrder(order);

        orderProducer.sendMessage(event);

        return  "Order placed successfully";
    }
}
