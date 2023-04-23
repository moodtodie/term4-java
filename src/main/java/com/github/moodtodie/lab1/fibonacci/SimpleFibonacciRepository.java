package com.github.moodtodie.lab1.fibonacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleFibonacciRepository implements FibonacciRepository {
    public static final Logger logger = LoggerFactory.getLogger(SimpleFibonacciRepository.class);

    @Override
    @Cacheable("fibonacci")
    public Fibonacci getByIndex(int index) {
        logger.info(String.format("Calculating fibonacci value with index %d", index));
        return new Fibonacci(Integer.toString(index));
    }
}
