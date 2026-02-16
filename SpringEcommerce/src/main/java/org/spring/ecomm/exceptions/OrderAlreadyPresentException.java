package org.spring.ecomm.exceptions;

public class OrderAlreadyPresentException extends RuntimeException {
    public OrderAlreadyPresentException(String message) {
        super(message);
    }
}
