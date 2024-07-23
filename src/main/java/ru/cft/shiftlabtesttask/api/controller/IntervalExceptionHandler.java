package ru.cft.shiftlabtesttask.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.cft.shiftlabtesttask.core.exception.IntervalFormatException;
import ru.cft.shiftlabtesttask.core.exception.IntervalNotFoundException;
import ru.cft.shiftlabtesttask.core.exception.ServiceNotFoundException;

@RestControllerAdvice
public class IntervalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handle(IntervalFormatException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IntervalNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(ServiceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(Exception exception) {
        return ResponseEntity.status(500).body(exception.getMessage());
    }
}
