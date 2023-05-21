package com.github.moodtodie.lab1.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciEntityRepository extends CrudRepository<FibonacciEntity, Integer> {
    FibonacciEntity findFibonacciEntityByIndex(int index);
}
