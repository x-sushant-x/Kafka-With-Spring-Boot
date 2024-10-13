package com.sushant.kafka.learning.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    
    @KafkaListener(topics = "location", groupId = "myKafkaGroup")
    public void consume(String message) {
        System.out.println("Consuming Message: " + message);
    }
}
