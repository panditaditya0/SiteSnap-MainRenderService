package com.easyrender.MainPreRender.controller;

import com.easyrender.MainPreRender.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.timestamp = LocalDateTime.now();
        errorResponse.message = e.getMessage();
        errorResponse.details = e.getStackTrace().toString();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
