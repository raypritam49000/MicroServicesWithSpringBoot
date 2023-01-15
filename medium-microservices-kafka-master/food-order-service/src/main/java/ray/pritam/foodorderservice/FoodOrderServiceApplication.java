package ray.pritam.foodorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodOrderServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(FoodOrderServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FoodOrderServiceApplication.class, args);
        logger.info("Running...");
    }

}
