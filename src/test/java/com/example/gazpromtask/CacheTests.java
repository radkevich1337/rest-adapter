package com.example.gazpromtask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class CacheTests extends AbstractTest {
    private final String DATA_ONE = "{ \"intA\": 10, \"intB\": 10}";
    private final String DATA_TWO = "{ \"intA\": 14, \"intB\": -7}";

    @Test
    void endpointAdd() throws Exception {
        this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();

        long timeStart = System.currentTimeMillis();
        this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        long timeEnd = System.currentTimeMillis();

        assertTrue(timeEnd - timeStart < 1000);
    }

    @Test
    void endpointDivide() throws Exception {
        this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();

        long timeStart = System.currentTimeMillis();
        this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        long timeEnd = System.currentTimeMillis();

        assertTrue(timeEnd - timeStart < 1000);
    }

    @Test
    void endpointMultiply() throws Exception {
        this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();

        long timeStart = System.currentTimeMillis();
        this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        long timeEnd = System.currentTimeMillis();

        assertTrue(timeEnd - timeStart < 1000);
    }

    @Test
    void endpointSubtract() throws Exception {
        this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();

        long timeStart = System.currentTimeMillis();
        this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        long timeEnd = System.currentTimeMillis();

        assertTrue(timeEnd - timeStart < 1000);
    }
}
