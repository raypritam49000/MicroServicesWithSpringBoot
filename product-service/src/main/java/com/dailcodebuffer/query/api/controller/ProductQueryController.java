package com.dailcodebuffer.query.api.controller;

import com.dailcodebuffer.command.api.model.ProductRestModel;
import com.dailcodebuffer.query.api.queries.GetProductQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        GetProductQuery getProductQuery = new GetProductQuery();
        List<ProductRestModel> productRestModels =
                queryGateway.query(getProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModels;
    }
}
