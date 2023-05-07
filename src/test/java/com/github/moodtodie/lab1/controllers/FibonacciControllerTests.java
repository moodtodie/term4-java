package com.github.moodtodie.lab1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTests {

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
        assertEquals("{\"value\":\"0\"}", result.getResponse().getContentAsString());
    }

    @Test
    void emptyUrl() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("{\"value\":\"0\"}", result.getResponse().getContentAsString());
    }

    @Test
    void urlWithWrongIndex() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/fib?index=3g");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void postIndexList() throws Exception {
        int[] requestBody = {7, 3, 13, 5, 11, 3, 8};
        RequestBuilder request = MockMvcRequestBuilders.post("/fib").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(requestBody));
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("[{\"value\":\"13\"},{\"value\":\"2\"},{\"value\":\"233\"},{\"value\":\"5\"}," + "{\"value\":\"89\"},{\"value\":\"2\"},{\"value\":\"21\"}]", result.getResponse().getContentAsString());
    }
}
