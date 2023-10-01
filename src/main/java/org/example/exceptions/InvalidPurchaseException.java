package org.example.exceptions;

public class InvalidPurchaseException extends RuntimeException {
    public InvalidPurchaseException(String format) {
        super(format);
    }
}
