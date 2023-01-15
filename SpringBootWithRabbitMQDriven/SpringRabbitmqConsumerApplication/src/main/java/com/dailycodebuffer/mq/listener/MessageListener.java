package com.dailycodebuffer.mq.listener;

import com.dailycodebuffer.mq.config.MQConfig;
import com.dailycodebuffer.mq.message.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues=MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }
}
