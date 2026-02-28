package com.example.demo.controller;

import com.example.demo.kafka.PaymentProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentProducer producer;

    public PaymentController(PaymentProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/{accountId}")
    public String createPayment(@PathVariable String accountId,
                                @RequestBody String body) {

        producer.sendPayment(accountId, body);
        return "Payment event sent!";
    }
}