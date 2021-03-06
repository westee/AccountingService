package com.westee.accounting.controller;

import com.westee.accounting.model.service.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController  {
    private AtomicLong counter = new AtomicLong();

    @GetMapping(path = "v1/greeting")
    public Greeting sayHello(@RequestParam("name") String name){
        return new Greeting(counter.incrementAndGet(), name);
    }
}
