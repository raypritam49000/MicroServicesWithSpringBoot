package com.ray.foodorderconsumer.services;

import com.ray.foodorderconsumer.domain.FoodOrder;
import com.ray.foodorderconsumer.repo.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {
    private final FoodOrderRepository foodOrderRepository;

    public FoodOrderService(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    public void persistFoodOrder(FoodOrder foodOrder) {
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);
        log.info("food order persisted {}", persistedFoodOrder);
    }

}
