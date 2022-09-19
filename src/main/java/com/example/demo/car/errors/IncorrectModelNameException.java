package com.example.demo.car.errors;

public class IncorrectModelNameException extends RuntimeException {
    public IncorrectModelNameException(String errorMessage) {
        super(errorMessage);
    }
}
