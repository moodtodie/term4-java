package com.github.moodtodie.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FibonacciTests {
    private Fibonacci fibonacci;

    @Test
    public void correctValue() {
        fibonacci = new Fibonacci("8");
        assertEquals("21", fibonacci.value());
    }

    @Test
    public void valueLessThenZero() {
        fibonacci = new Fibonacci("-4");
        assertEquals("0", fibonacci.value());
    }

    @Test
    public void wrongValue() {
        fibonacci = new Fibonacci("4f");
        assertNull(fibonacci.value());
    }

    @Test
    public void blankValue() {
        fibonacci = new Fibonacci(" ");
        assertNull(fibonacci.value());
    }

    @Test
    public void emptyValue() {
        fibonacci = new Fibonacci("");
        assertNull(fibonacci.value());
    }

    @Test
    public void nullValue() {
        fibonacci = new Fibonacci(null);
        assertNull(fibonacci.value());
    }
}
