package ray.pritam.producerservice.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ray.pritam.producerservice.dto.Message;


@Component
public class Producer {
    private Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Message message) {
        LOGGER.info("Produce to the Message : "+message.getMessage());
        jmsTemplate.convertAndSend(message.getQueueName(), message.getMessage());
    }

}