package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(
            topics = "payment-topic",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(String message, Acknowledgment ack) {

        try {
            System.out.println("Processing message: " + message);

            // Simulate DB logic
            Thread.sleep(500);

            // Commit offset only after success
            ack.acknowledge();

        } catch (Exception e) {
            System.out.println("Error processing message");
            // No ack → will retry
        }
    }
}