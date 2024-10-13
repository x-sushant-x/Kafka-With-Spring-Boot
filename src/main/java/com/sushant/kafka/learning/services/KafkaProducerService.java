package com.sushant.kafka.learning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, Object message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String dataToSend = objectMapper.writeValueAsString(message);
        kafkaTemplate.send(topic, key, dataToSend);
    }
}
