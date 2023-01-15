package com.programmingtechie.inventryservice.service;

import com.programmingtechie.inventryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    public List<InventoryResponse> isInStock(List<String> skuCode);
}
