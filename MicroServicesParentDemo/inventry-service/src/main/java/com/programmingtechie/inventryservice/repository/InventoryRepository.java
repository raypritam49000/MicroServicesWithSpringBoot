package com.programmingtechie.inventryservice.repository;

import com.programmingtechie.inventryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    public List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
