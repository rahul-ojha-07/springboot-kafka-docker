package com.example.springbootkafka.kafka;

import com.example.springbootkafka.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.management.Notification;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${spring-boot-kafka.kafka.topics.create-order}",containerFactory = "kafkaListenerContainerFactory")
    public void createOrderListener(@Payload Order order, Acknowledgment acknowledgment) {
        log.info("Received Order, {}", order);
        acknowledgment.acknowledge();
    }

}
