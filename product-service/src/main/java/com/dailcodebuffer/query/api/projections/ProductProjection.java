package com.dailcodebuffer.query.api.projections;

import com.dailcodebuffer.command.api.entity.Product;
import com.dailcodebuffer.command.api.model.ProductRestModel;
import com.dailcodebuffer.command.api.repository.ProductRepository;
import com.dailcodebuffer.query.api.queries.GetProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {
    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery getProductQuery) {
        List<Product> products = this.productRepository.findAll();

        List<ProductRestModel> productRestModels = products.stream()
                .map(product -> ProductRestModel.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build()
                ).collect(Collectors.toList());

        return productRestModels;
    }
}
