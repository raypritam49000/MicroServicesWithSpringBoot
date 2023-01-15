package com.programmingtechie.productservices.services;

import com.programmingtechie.productservices.dto.ProductRequest;
import com.programmingtechie.productservices.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);
    public List<ProductResponse> getAllProducts();
}
