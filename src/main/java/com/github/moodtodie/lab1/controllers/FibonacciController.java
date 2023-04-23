package com.github.moodtodie.lab1.controllers;

import com.github.moodtodie.lab1.fibonacci.Fibonacci;
import com.github.moodtodie.lab1.fibonacci.FibonacciRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {
    public static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);
    private final FibonacciRepository fibonacci;

    public FibonacciController(FibonacciRepository fibonacci) {
        this.fibonacci = fibonacci;
    }

    @GetMapping("/fib")
    public Fibonacci fibonacci(@Valid @RequestParam(value = "index", defaultValue = "0") int index) {
        logger.info(String.format("Get fibonacci request | index = %s", index));

        final var fib = fibonacci.getByIndex(index);
        logger.info(String.format("Value with index %d equal \"%s\".", index, fib.value()));
        return fib;
    }
}