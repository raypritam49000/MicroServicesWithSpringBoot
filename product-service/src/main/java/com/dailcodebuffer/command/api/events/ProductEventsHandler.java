package com.dailcodebuffer.command.api.events;

import com.dailcodebuffer.command.api.entity.Product;
import com.dailcodebuffer.command.api.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreateEvent event){
        Product product = new Product();
        BeanUtils.copyProperties(event,product);
        this.productRepository.save(product);
    }
}
