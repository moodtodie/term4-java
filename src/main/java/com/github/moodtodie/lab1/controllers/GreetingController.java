package com.github.moodtodie.lab1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    public static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/")
    public String home(Model model) {
        logger.info("Get home page");
        return "home";
    }
}