package com.example.demo.interview;

import com.example.demo.model.SumPayload;
import com.example.demo.service.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private SumService sumService;

    @PostMapping(path = "/sum")
    public int sum(@RequestBody SumPayload payload) {
        return sumService.sum(payload);
    }
}
