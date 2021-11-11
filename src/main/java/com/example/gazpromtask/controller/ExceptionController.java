package com.example.gazpromtask.controller;

import com.example.gazpromtask.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        StringBuilder message = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            message.append(((FieldError) error).getField()).append(" - ").append(error.getDefaultMessage()).append("\n");
        });
        return new ResponseEntity<>(new Message(message.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handlerHttpMessageNotReadableException() {
        return new ResponseEntity<>(new Message("JSON parse error"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handlerArithmeticException(ArithmeticException ex) {
        return new ResponseEntity<>(new Message(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerDefaultException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
