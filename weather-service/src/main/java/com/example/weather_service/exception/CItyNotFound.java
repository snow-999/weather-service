package com.example.weather_service.exception;

public class CItyNotFound extends RuntimeException {
    public CItyNotFound(String message) {
        super(message);
    }
}
