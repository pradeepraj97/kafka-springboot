package com.test.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumerService {
    @KafkaListener(topics = "incident", groupId = "sgrcGroup")
    void listen(String message);
}
