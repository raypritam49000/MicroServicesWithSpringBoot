package com.dailcodebuffer.command.api.aggregate;

import com.dailcodebuffer.command.api.commands.CreateProductCommand;
import com.dailcodebuffer.command.api.events.ProductCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class MyProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public MyProductAggregate() {
    }

    @CommandHandler
    public MyProductAggregate(CreateProductCommand createProductCommand) {
        // You can perform all validations
        ProductCreateEvent productCreateEvent = new ProductCreateEvent();
        BeanUtils.copyProperties(createProductCommand,productCreateEvent);
        AggregateLifecycle.apply(productCreateEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreateEvent productCreateEvent){
        this.name = productCreateEvent.getName();
        this.price = productCreateEvent.getPrice();
        this.productId = productCreateEvent.getProductId();
        this.price = productCreateEvent.getPrice();
    }
}
