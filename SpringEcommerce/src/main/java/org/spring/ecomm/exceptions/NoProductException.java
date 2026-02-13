package org.spring.ecomm.exceptions;

public class NoProductException extends RuntimeException {
    public NoProductException(String message) {
        super(message);
    }
}
