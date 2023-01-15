package com.dailycodebuffer.consumer.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
public class SpringbootActiveMqRealtimeProjectApplication  {

    public static void main(String[] args) {
       ApplicationContext ctx = SpringApplication.run(SpringbootActiveMqRealtimeProjectApplication.class, args);

        JmsTemplate jmsTemplate= ctx.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("javainuse", "test message");

    }

}
