package com.example.springbootkafka;

import com.example.springbootkafka.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaApplication {
    @Autowired
    KafkaConfig kafkaConfig;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }

}
