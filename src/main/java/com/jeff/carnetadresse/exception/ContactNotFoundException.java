package com.jeff.carnetadresse.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(Long id) {
        super("could not find contact %s".formatted(id));
    }
}
