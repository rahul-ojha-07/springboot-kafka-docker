package com.example.springbootkafka.controller;


import com.example.springbootkafka.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestController {

    @Autowired
    KafkaConfig kafkaConfig;
    @GetMapping("test")
    ResponseEntity<?> getData() {
        return ResponseEntity.ok(kafkaConfig);
    }
}
