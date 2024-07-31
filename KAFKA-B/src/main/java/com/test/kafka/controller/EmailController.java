package com.test.kafka.controller;


import com.test.kafka.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailController {
    private final KafkaProducerService kafkaProducerService;

    public EmailController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }


    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody String message) {
        kafkaProducerService.sendIncidentEmail("test", message);
        return ResponseEntity.ok("Email request sent to Kafka topic.");
    }
}
