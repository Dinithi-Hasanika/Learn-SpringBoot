package com.example.demo.handler;

import com.example.demo.exceptions.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<Object> apiError(APIException ex) {
        return ResponseEntity.status(ex.getError_status()).body(ex.getErrorResponse());
    }
}
