package ru.cft.shiftlabtesttask.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IntervalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Error> handle(Exception exception){
        return ResponseEntity.status(400).body(new Error(exception.getMessage()));
    }
}
