package com.github.moodtodie.lab1.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CounterTest {
    @Autowired
    private Counter counter;

    @Autowired
    private MockMvc mvc;

    @Test
    void counterWeb() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib?index=9");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());

        request = MockMvcRequestBuilders.get("/fib?index=13");
        result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());

        request = MockMvcRequestBuilders.get("/fib?index=4");
        result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());

        request = MockMvcRequestBuilders.get("/fib?index=13");
        result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());

        assertEquals(counter.get(), 4);
    }
}
