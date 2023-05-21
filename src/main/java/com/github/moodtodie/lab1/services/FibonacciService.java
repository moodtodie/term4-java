package com.github.moodtodie.lab1.services;

import com.github.moodtodie.lab1.fibonacci.Fibonacci;
import com.github.moodtodie.lab1.fibonacci.FibonacciRepository;
import com.github.moodtodie.lab1.models.FibonacciEntity;
import com.github.moodtodie.lab1.models.FibonacciEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FibonacciService implements FibonacciRepository {
    public static final Logger logger = LoggerFactory.getLogger(FibonacciService.class);
    public final FibonacciEntityRepository repository;

    public FibonacciService(FibonacciEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("fibonacci")
    public Fibonacci getByIndex(int index) {
        if (index < 0 || index > 92) {
            return new Fibonacci(0);
        }

        FibonacciEntity entity = repository.findFibonacciEntityByIndex(index);
        if (entity == null) {
            entity = new FibonacciEntity(index);
            repository.save(entity);
            logger.info(String.format("The value at index %d is saved to the database", index));
        }

        logger.info(String.format("The value at index %d is saved to the cache", index));
        return new Fibonacci(entity);
    }

    @Override
    @Async
    public void saveAsync(int index) {
        if (index < 0 || index > 92)
            return;

        FibonacciEntity entity = repository.findFibonacciEntityByIndex(index);
        if (entity == null) {
            entity = new FibonacciEntity(index);
            repository.save(entity);
        }
    }
}
