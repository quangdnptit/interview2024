package com.example.demo.service;

import com.example.demo.model.SumPayload;
import org.springframework.stereotype.Service;

@Service
public class SumService {
    public int sum(SumPayload payload) {
        return payload.getNum1() + payload.getNum2();
    }
}
