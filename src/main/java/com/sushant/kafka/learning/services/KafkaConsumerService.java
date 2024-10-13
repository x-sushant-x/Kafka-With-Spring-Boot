package com.sushant.kafka.learning.services;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushant.kafka.learning.models.DTO.Location;

@Service
public class KafkaConsumerService {
    
    @KafkaListener(topics = "location", groupId = "myKafkaGroup")
    public void consumeLocationCoordinates(final Location location) throws Exception {
        try {
            System.out.println(location.getLatitude() + " : " + location.getLongitude());
        } catch (Exception e) {
            System.out.println("Exception [consumeLocationCoordinates] : " + e.getMessage());
        }
    }

    @DltHandler
    public void handleDeadLetterTopic(
        final Location location, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) {
        System.out.println("Event recieved on DTL with topic [" + topic + "] and payload [" + location + "]");
    }
}
