package com.streaming.pessoa.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
    @KafkaListener(topics = "${kafka.topic.notify.pessoa}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        System.out.println(">>>>>>>>>>> Received message: " + message);
    }
}
