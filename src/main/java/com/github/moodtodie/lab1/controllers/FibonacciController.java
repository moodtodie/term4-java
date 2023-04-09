package com.github.moodtodie.lab1.controllers;

import com.github.moodtodie.lab1.entities.Fibonacci;
import com.github.moodtodie.lab1.storage.CachingConfig;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {
    public static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);
    public final CachingConfig cachingConfig = new CachingConfig();

    @GetMapping("/fib")
    public Fibonacci fibonacci(@Valid @RequestParam(value = "index", defaultValue = "0") int index) {
        logger.info(String.format("Get fibonacci request | index = %s", index));
        if (cachingConfig.exist(index)){
            logger.info(String.format("Index %d is in the cache.", index));
            Fibonacci fib = cachingConfig.get(index);
            logger.info(String.format("Value \"%s\" received from cache.", fib.value()));
            return fib;
        }
        cachingConfig.add(index);
        logger.info(String.format("Value with index %d added to cache.", index));
        return cachingConfig.get(index);
    }
}