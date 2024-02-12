package com.sourcemind.employeemanagement.exception;

public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(String message){
        super(message);
    }
}
