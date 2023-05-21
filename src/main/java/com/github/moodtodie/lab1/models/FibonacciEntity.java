package com.github.moodtodie.lab1.models;

import com.github.moodtodie.lab1.fibonacci.Fibonacci;
import jakarta.persistence.*;

@Entity
@Table(name = "fibonacci")
public class FibonacciEntity {

    @Id
    @Column(name = "index", updatable = false, nullable = false)
    private int index;

    @Column(name = "number", nullable = false)
    private String number;

    public FibonacciEntity() {
    }

    public FibonacciEntity(int index) {
        this.index = index;
        this.number = new Fibonacci(index).value();
    }

    public String getNumber() {
        return number;
    }
}
