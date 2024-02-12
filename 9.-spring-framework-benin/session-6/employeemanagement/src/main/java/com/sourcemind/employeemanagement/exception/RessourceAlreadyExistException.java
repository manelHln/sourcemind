package com.sourcemind.employeemanagement.exception;

public class RessourceAlreadyExistException extends RuntimeException{
    public RessourceAlreadyExistException(String message){
        super(message);
    }
}
