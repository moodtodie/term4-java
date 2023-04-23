package com.github.moodtodie.lab1.fibonacci;

import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Fibonacci(String value) {
    public static final Logger logger = LoggerFactory.getLogger(Fibonacci.class);

    public Fibonacci(@NotBlank(message = "Class Fibonacci can't get blank parameter.") String value) {
        int index;

        try {
            index = Integer.parseInt(value);
        } catch (Exception ignored) {
            logger.error(String.format("Can't convert from \"%s\" to long.", value));
            this.value = null;
            return;
        }

        if (index > 92) {
            logger.warn("Unable to calculate: index too large.");
            this.value = null;
            return;
        }

        if (index < 0)
            index = 0;

        if (index == 0 || index == 1) {
            this.value = String.valueOf(index);
            return;
        }

        final double phi = (1 + Math.sqrt(5)) / 2;
        this.value = String.valueOf(Math.round((Math.pow(phi, index) - Math.pow(-phi, -index)) / Math.sqrt(5)));
    }
}