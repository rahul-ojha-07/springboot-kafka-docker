package com.example.springbootkafka.kafka;

import com.example.springbootkafka.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final String topic;
    public KafkaProducer(KafkaTemplate<String, Order> kafkaTemplate, @Value("${spring-boot-kafka.kafka.topics.create-order}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public boolean sendCreateOrderEvent(Order order) throws ExecutionException, InterruptedException {
        SendResult<String, Order> sendResult = kafkaTemplate.send(topic, order).get();
        log.info("Create order {} event sent via kafka", order);
        log.info(sendResult.toString());
        return true;
    }
}
