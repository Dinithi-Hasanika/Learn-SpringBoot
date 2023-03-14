package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class APIException extends Exception{

    HttpStatus error_status;
    ErrorResponse errorResponse;

    public APIException(HttpStatus error_status, ErrorResponse errorResponse) {

        this.error_status = error_status;
        this.errorResponse = errorResponse;
    }

    public HttpStatus getError_status() {

        return error_status;
    }

    public void setError_status(HttpStatus error_status) {

        this.error_status = error_status;
    }

    public ErrorResponse getErrorResponse() {

        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {

        this.errorResponse = errorResponse;
    }
}
