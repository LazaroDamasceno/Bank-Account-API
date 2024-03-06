package com.api.v1.exception;

public class ForbiddenOperation extends RuntimeException {

    public ForbiddenOperation(String message) {
        super(message);
    }
    
}
