package ray.pritam.producerservice.controllers;

import org.springframework.web.bind.annotation.*;
import ray.pritam.producerservice.dto.Message;
import ray.pritam.producerservice.producers.Producer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final Producer producer;

    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/message")
    public String sendMessage(@RequestBody Message message){
        this.producer.sendMessage(message);
        return "message send it";
    }
}
