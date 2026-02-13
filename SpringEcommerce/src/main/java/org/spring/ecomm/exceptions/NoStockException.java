package org.spring.ecomm.exceptions;

public class NoStockException extends RuntimeException {
    public NoStockException(String message) {
        super(message);
    }
}
