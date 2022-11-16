package com.example.backendspringboottechiteasycontroller.exceptions;

import org.springframework.web.bind.annotation.RestController;


public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException() {
        super();
    }
    public RecordNotFoundException(String message) {
        super(message);
    }
}
