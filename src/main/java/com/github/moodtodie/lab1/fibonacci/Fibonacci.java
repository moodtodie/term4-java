package com.github.moodtodie.lab1.fibonacci;

import com.github.moodtodie.lab1.models.FibonacciEntity;
import jakarta.validation.constraints.*;

public record Fibonacci(String value) {
    public Fibonacci(@Max(92) @PositiveOrZero int index) {
        this(String.valueOf(Math.round((Math.pow(((1 + Math.sqrt(5)) / 2), index) - Math.pow(-((1 + Math.sqrt(5)) / 2), -index)) / Math.sqrt(5))));
    }

    public Fibonacci(@NotNull FibonacciEntity entity) {
        this(entity.getNumber());
    }
}
