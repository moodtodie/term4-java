package com.github.moodtodie.lab1.controllers;

import com.github.moodtodie.lab1.fibonacci.Fibonacci;
import com.github.moodtodie.lab1.fibonacci.FibonacciRepository;
import com.github.moodtodie.lab1.services.Counter;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FibonacciController {
    public static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);
    private final FibonacciRepository fibonacci;
    private final Counter counter;

    public FibonacciController(FibonacciRepository fibonacci, Counter counter) {
        this.fibonacci = fibonacci;
        this.counter = counter;
    }

    @GetMapping("/fib")
    public Fibonacci fibonacci(@Valid @RequestParam(value = "index", defaultValue = "0") int index) {
        logger.info(String.format("Get fibonacci request | index = %s", index));

        counter.inc();
        final var fib = fibonacci.getByIndex(index);

        logger.info(String.format("Value with index %d equal \"%s\"", index, fib.value()));
        return fib;
    }

    @PostMapping("/fib")
    public ResponseEntity<?> fibonacci(@Valid @RequestBody List<Integer> indexList) {
        logger.info(String.format("Post fibonacci request | list = %s", indexList.toString()));
        counter.inc();
        List<Fibonacci> resultList = new ArrayList<>();

        int max = indexList.stream().mapToInt(Integer::intValue).max().orElseThrow();
        int min = indexList.stream().mapToInt(Integer::intValue).min().orElseThrow();
        double avg = indexList.stream().mapToInt(Integer::intValue).average().orElseThrow();
        logger.info(String.format("Post request stats | max = %d, min = %d, avg = %.2f", max, min, avg));

        indexList.forEach(n -> resultList.add(fibonacci.getByIndex(n)));

        max = resultList.stream()
                .mapToInt(f -> Integer.parseInt(f.value()))
                .max().orElseThrow();
        min = resultList.stream()
                .mapToInt(f -> Integer.parseInt(f.value()))
                .min().orElseThrow();
        avg = resultList.stream()
                .mapToInt(f -> Integer.parseInt(f.value()))
                .average().orElseThrow();
        logger.info(String.format("Response stats for post request | max = %d, min = %d, avg = %.2f", max, min, avg));

        logger.info("Post request completed");

        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
}
