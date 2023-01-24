package com.jeff.carnetadresse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntityNotSaveException extends RuntimeException {
    private String errorMessage;
}
