package com.example.springbootkafka.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orderId;
    private Date dateOfCreation = new Date();
    private String content;
}
