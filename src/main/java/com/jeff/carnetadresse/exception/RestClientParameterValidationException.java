package com.jeff.carnetadresse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

@Getter
@Setter
@AllArgsConstructor
public class RestClientParameterValidationException extends RuntimeException {
    private BindingResult bindingResult;
}
