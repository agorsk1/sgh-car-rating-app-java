package com.example.demo.car.errors;

public class IncorrectMakeNameException extends RuntimeException {
    public IncorrectMakeNameException(String errorMessage) {
        super(errorMessage);
    }
}
