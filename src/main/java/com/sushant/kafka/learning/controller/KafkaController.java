package com.sushant.kafka.learning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.kafka.learning.services.KafkaProducerService;

@RestController
@RequestMapping(value = "/api/v1/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;
    
    @RequestMapping(value = "/produce", method = RequestMethod.POST)
    public void produceData(final @RequestBody Object data,
                            final @RequestParam(name = "topic") String topic,
                            final @RequestParam(name = "key") String key) {
        kafkaProducerService.sendMessage(topic, key, data.toString());
    }
}
