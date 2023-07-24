package com.cargobook.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}