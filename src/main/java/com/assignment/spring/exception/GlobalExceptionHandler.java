package com.assignment.spring.exception;

import com.assignment.spring.client.exception.OpenWeatherClientException;
import com.assignment.spring.client.exception.OpenWeatherServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OpenWeatherClientException.class)
    public ResponseEntity<Error> handleClientException(OpenWeatherClientException ex, WebRequest request) {
        Error body = new Error(ex.getStatus(), ex.getReason());
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getStatus()));
    }

    @ExceptionHandler(OpenWeatherServerException.class)
    public ResponseEntity<Error> handleClientException(OpenWeatherServerException ex, WebRequest request) {
        Error body = new Error(ex.getStatus(), ex.getReason());
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getStatus()));
    }
}
