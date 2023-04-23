package com.github.moodtodie.lab1.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {
    Counter counter = new Counter();

    @Test
    public void counter() {
        for (int i = 0; i < 15; i++)
            counter.inc();
        assertEquals(counter.get(), 15);

        for (int i = 0; i < 17; i++)
            counter.inc();
        assertEquals(counter.get(), (15 + 17));
    }
}
