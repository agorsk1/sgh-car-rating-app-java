package com.example.demo.rating.errors;

public class IncorrectRatingValueException extends RuntimeException {
    public IncorrectRatingValueException(String errorMessage) {
        super(errorMessage);
    }
}
