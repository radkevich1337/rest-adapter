package com.example.gazpromtask.model;

import lombok.Getter;

@Getter
public class Message {
    private final String message;

    public Message(String message) {
        this.message = message;
    }
}
