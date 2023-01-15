package com.jeff.carnetadresse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ContactNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ContactNotFoundException.class)
    ResponseEntity<String> contactNotHandler(ContactNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
