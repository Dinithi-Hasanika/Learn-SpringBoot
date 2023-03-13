package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class APIException extends Exception{

    HttpStatus error_status;
    String errorMsg;

    public APIException(HttpStatus error_status, String errorMsg) {

        this.error_status = error_status;
        this.errorMsg = errorMsg;
    }

    public HttpStatus getError_status() {

        return error_status;
    }

    public void setError_status(HttpStatus error_status) {

        this.error_status = error_status;
    }

    public String getErrorMsg() {

        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {

        this.errorMsg = errorMsg;
    }
}
