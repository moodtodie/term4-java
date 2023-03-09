package com.github.moodtodie.lab1.controllers;

import com.github.moodtodie.lab1.entities.Fibonacci;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {
    @GetMapping("/fib")
    public Fibonacci fibonacci(@RequestParam(value = "index", defaultValue = "5") String index) {
        return new Fibonacci(index);
    }
}