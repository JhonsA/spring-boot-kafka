package com.kafka.provider.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400"); // Defecto -1, no se borran nunca
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // 1GB defecto, Tamano maximo del segmento
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1073741824"); // Tamano maximo de cada msg, defecto 1MB

        return TopicBuilder.name("example-topic-java")
            .partitions(2)
            .replicas(2)
            .configs(configurations)
            .build();
    }

}
