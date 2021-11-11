package com.example.gazpromtask.controller;


import com.example.gazpromtask.model.IntegerPair;
import com.example.gazpromtask.service.SoapClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.soap.SOAPException;

@RestController
public class CalculatorController {
    private final SoapClientService soapClientService;

    @Autowired
    public CalculatorController(SoapClientService soapClientService) {
        this.soapClientService = soapClientService;
    }

    @PostMapping("/add")
    @Cacheable("add")
    public ResponseEntity<Object> add(@Valid @RequestBody IntegerPair integerPair) throws SOAPException, InterruptedException {
        int result = soapClientService.sendMessage(integerPair.getIntA(), integerPair.getIntB(), "Add");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/divide")
    @Cacheable("divide")
    public ResponseEntity<Object> divide(@Valid @RequestBody IntegerPair integerPair) throws SOAPException, InterruptedException {
        integerPair.checkBEqualZero();
        int result = soapClientService.sendMessage(integerPair.getIntA(), integerPair.getIntB(), "Divide");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/multiply")
    @Cacheable("multiply")
    public ResponseEntity<Object> multiply(@Valid @RequestBody IntegerPair integerPair) throws SOAPException, InterruptedException {
        int result = soapClientService.sendMessage(integerPair.getIntA(), integerPair.getIntB(), "Multiply");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/subtract")
    @Cacheable("subtract")
    public ResponseEntity<Object> subtract(@Valid @RequestBody IntegerPair integerPair) throws SOAPException, InterruptedException {
        int result = soapClientService.sendMessage(integerPair.getIntA(), integerPair.getIntB(), "Subtract");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
