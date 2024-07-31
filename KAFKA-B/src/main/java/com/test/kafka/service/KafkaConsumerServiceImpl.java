package com.test.kafka.service;


import com.test.kafka.config.MailerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {


    @KafkaListener(topics = "test", groupId = "emailNotificationGrp")
    @Override
    public void listen(String message) {
        MailerConfig.sendEmail("pradeeprajcs55@lissomsoft.com", "Kafka test", "Kafka Email Test");
    }

}
