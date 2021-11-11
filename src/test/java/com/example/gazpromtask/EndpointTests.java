package com.example.gazpromtask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class EndpointTests extends AbstractTest {
    private final String DATA_ONE = "{ \"intA\": 10, \"intB\": 10}";
    private final String DATA_TWO = "{ \"intA\": 14, \"intB\": -7}";

    @Test
    void endpointAdd() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), 20);

        result = this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), 7);
    }

    @Test
    void endpointDivide() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), 1);

        result = this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), -2);
    }

    @Test
    void endpointMultiply() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), 100);

        result = this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), -98);
    }

    @Test
    void endpointSubtract() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), 0);

        result = this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
        assertEquals(Integer.parseInt(result.getResponse().getContentAsString()), 21);
    }
}
