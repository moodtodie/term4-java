package com.github.moodtodie.lab1.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTests {

    private final String zeroOut = "{\"value\":\"0\"}";

    @Autowired
    private MockMvc mvc;

    @Test
    void correctUrl() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib?index=9");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("{\"value\":\"34\"}", result.getResponse().getContentAsString());
    }

    @Test
    void indexLessThenZeroUrl() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib?index=-12");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(zeroOut, result.getResponse().getContentAsString());
    }

    @Test
    void emptyUrl() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(zeroOut, result.getResponse().getContentAsString());
    }

    @Test
    void urlWithWrongIndex() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib?index=3g");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }
}
