package com.eventManagement.eventManagement.exception;

public class BusinessException extends RuntimeException{



    public BusinessException(String message) {
        super(String.format(message));
    }
}
