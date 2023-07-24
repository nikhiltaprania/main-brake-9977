package com.cargobook.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}