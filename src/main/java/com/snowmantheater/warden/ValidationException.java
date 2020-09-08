package com.snowmantheater.warden;

public class ValidationException extends RuntimeException {
    private final Object value;

    public ValidationException(Object value, String message) {
        super(message);
        this.value = value;
    }

    public ValidationException(Object value, String message, Throwable cause) {
        super(message, cause);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
