package ray.pritam.consumer.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Listener {
	private Logger LOGGER = LoggerFactory.getLogger(Listener.class);

	@JmsListener(destination = "ray")
	public void consume(String message) {
		LOGGER.info("Consume to the message : " + message);
	}

}