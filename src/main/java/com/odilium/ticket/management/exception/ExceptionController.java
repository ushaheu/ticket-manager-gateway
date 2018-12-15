package com.odilium.ticket.management.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Error> httpErrorHandler(HttpClientErrorException e) {
        Error error;
        try {
            error = new Error("invalid_request", e.getMessage());
        } catch (Exception ex) {
            error = new Error("invalid_request", e.getMessage());
        }
        return new ResponseEntity<>(error, e.getStatusCode());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> invalidFormatErrorHandler(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new Error("Messaging Error", "Request body could not be mapped."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Error> invalidFormatErrorHandler(InvalidFormatException e) {
        return new ResponseEntity<>(new Error("Invalid Format Exception", "Request body could not be mapped."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> genericErrorHandler(Exception e) {
        Error error = new Error("internal_error", "An internal error occurred");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
