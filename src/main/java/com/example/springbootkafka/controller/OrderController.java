package com.example.springbootkafka.controller;

import com.example.springbootkafka.entity.Order;
import com.example.springbootkafka.kafka.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final KafkaProducer kafkaProducer;

    public OrderController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        if (kafkaProducer.sendCreateOrderEvent(order)) {
            return ResponseEntity.ok(order);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
