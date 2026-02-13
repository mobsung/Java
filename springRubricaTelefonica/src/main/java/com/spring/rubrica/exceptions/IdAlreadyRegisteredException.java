package com.spring.rubrica.exceptions;

public class IdAlreadyRegisteredException extends RuntimeException {
    public IdAlreadyRegisteredException(String message) {
        super(message);
    }
}
