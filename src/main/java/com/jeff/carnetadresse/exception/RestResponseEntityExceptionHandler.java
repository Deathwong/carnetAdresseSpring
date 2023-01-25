package com.jeff.carnetadresse.exception;

import com.jeff.carnetadresse.domain.rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.jeff.carnetadresse.utils.Constant.METHOD_ARGUMENT_NOT_VALID_MESSAGE;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ErrorResponse> handleContactNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getErrorMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> handleStandardException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(EntityNotSaveException.class)
    ResponseEntity<ErrorResponse> handleEntityNotSaveException(EntityNotSaveException ex) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getErrorMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RestClientParameterValidationException.class)
    protected ResponseEntity<ErrorResponse> handleRestClientParameterValidationException(
            RestClientParameterValidationException ex) {

        Map<String, String> errorsMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorsMap.put(fieldName, errorMessage);
        });

        String errorMessageValidation = errorsMap.entrySet().stream()
                .map(mapentry -> mapentry.getKey() + ": " + mapentry.getValue())
                .collect(Collectors.joining("; "));

        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                METHOD_ARGUMENT_NOT_VALID_MESSAGE.formatted(errorMessageValidation)), HttpStatus.BAD_REQUEST);
    }
}