package com.snowmantheater.warden;

/**
 * {@link ValidationException}s are thrown when values cannot be accepted or are explicitly rejected.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class ValidationException extends RuntimeException {
    private final Object value;

    /**
     * Creates a new {@link ValidationException} with the rejected value and the reason message.
     *
     * @param value The rejecting value
     * @param message The reason message
     */
    public ValidationException(Object value, String message) {
        super(message);
        this.value = value;
    }

    /**
     * Returns the rejected value.
     *
     * @return The rejected value
     */
    public Object getValue() {
        return value;
    }
}
