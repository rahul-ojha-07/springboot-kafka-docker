package com.example.springbootkafka.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring-boot-kafka.kafka")
public class KafkaConfig {
     String bootstrapServers;
     String groupId;
     Map<String, String> topics;
}
