package com.github.moodtodie.lab1.fibonacci;

import com.github.moodtodie.lab1.models.FibonacciEntity;
import com.github.moodtodie.lab1.models.FibonacciEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SimpleFibonacciRepository implements FibonacciRepository {
    public static final Logger logger = LoggerFactory.getLogger(SimpleFibonacciRepository.class);
    public final FibonacciEntityRepository repository;

    public SimpleFibonacciRepository(FibonacciEntityRepository repository) {
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
}
