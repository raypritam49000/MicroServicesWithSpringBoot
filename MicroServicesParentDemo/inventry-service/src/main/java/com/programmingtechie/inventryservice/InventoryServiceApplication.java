package com.programmingtechie.inventryservice;

import com.programmingtechie.inventryservice.model.Inventory;
import com.programmingtechie.inventryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
//            Inventory inventory = new Inventory();
//            inventory.setQuantity(100);
//            inventory.setSkuCode("iphone_13");
//
//            Inventory inventory1 = new Inventory();
//            inventory1.setQuantity(100);
//            inventory1.setSkuCode("iphone_13_red");
//
//            Inventory inventory2 = new Inventory();
//            inventory2.setQuantity(100);
//            inventory2.setSkuCode("iphone_13_pink");
//
//            inventoryRepository.save(inventory);
//            inventoryRepository.save(inventory1);
//            inventoryRepository.save(inventory2);
        };
    }

}
