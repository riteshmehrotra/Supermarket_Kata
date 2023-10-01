package org.example;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String format) {
        super(format);
    }
}
