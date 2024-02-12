package com.sourcemind.employeemanagement.exception;

public class RequestNotAuthorizedException extends  RuntimeException {
    public RequestNotAuthorizedException(String message){
        super(message);
    }
}
