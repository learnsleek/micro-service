package com.learnsleek.exception;

public class PersistentException extends APIRequestException {
    public PersistentException(String message) {
        super(message);
    }

    public PersistentException(String message, Throwable cause) {
        super(message, cause);
    }
}
