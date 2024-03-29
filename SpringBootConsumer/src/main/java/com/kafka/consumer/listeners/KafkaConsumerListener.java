package com.kafka.consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {
    
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = {"example-topic-java"}, groupId = "default")
    public void listener(String message) {
        LOGGER.info("MSG: " + message);
    }

}
