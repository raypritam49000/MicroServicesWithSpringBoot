package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.dto.OrderRequest;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest) throws Exception;
}
