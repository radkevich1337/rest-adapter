package com.example.gazpromtask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class ExceptionTests extends AbstractTest {
    private final String DATA_ONE = "{ \"intA\": 10, \"intB\": null}";
    private final String DATA_TWO = "{ \"intA\": 14, \"intB\": \"abc\"}";
    private final String DATA_THREE = "{ \"intA\": 14}";
    private final String DATA_FOUR = "{ \"intA\": 14, \"intB\": 0}";

    @Test
    void endpointAdd() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(DATA_THREE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void endpointDivide() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_THREE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/divide").contentType(MediaType.APPLICATION_JSON).content(DATA_FOUR)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void endpointMultiply() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/multiply").contentType(MediaType.APPLICATION_JSON).content(DATA_THREE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void endpointSubtract() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_ONE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_TWO)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());

        result = this.mockMvc.perform(post("/subtract").contentType(MediaType.APPLICATION_JSON).content(DATA_THREE)).andReturn();
        assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());
    }
}
