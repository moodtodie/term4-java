package com.github.moodtodie.lab1.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Counter {
    public static final Logger logger = LoggerFactory.getLogger(Counter.class);
    private long counter;

    public Counter() {
        counter = 0;
    }

    public synchronized void inc() {
        counter++;
        logger.info(String.format("Total requests: %d", counter));
    }

    public synchronized long get() {
        return this.counter;
    }
}
