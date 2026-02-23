package org.spring.azienda.exceptions;

public class IdNonPresenteException extends RuntimeException {
    public IdNonPresenteException(String message) {
        super(message);
    }
}
