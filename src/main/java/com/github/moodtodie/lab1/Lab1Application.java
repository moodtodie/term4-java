package com.github.moodtodie.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class Lab1Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }
}