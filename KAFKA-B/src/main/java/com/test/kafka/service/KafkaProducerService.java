package com.test.kafka.service;

public interface KafkaProducerService {
    void sendIncidentEmail(String topic, String message);
}
