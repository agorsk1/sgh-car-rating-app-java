package com.example.demo.rating.errors;

public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException(String errorMessage) {
        super(errorMessage);
    }
}
