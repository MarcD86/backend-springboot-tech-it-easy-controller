package com.example.backendspringboottechiteasycontroller.exceptions;

import org.springframework.web.bind.annotation.RestController;


public class RecordNotFoundException extends RuntimeException {

    //default body
    public RecordNotFoundException() {
        super();
    }

    //message body
    public RecordNotFoundException(String message) {
        super(message);
    }
}
