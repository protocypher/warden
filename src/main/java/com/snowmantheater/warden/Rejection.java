package com.snowmantheater.warden;

import lombok.NonNull;

/**
 * {@link Rejection}s are thrown when values cannot be accepted or are explicitly rejected.
 *
 * @author benjamin@snowmantheater.com
 * @version 1.0.0
 */
public class Rejection extends RuntimeException {
    private final Object value;

    /**
     * Creates a new {@link Rejection} with the rejected value and the reason message.
     *
     * @param value The rejected value
     * @param message The reason message
     */
    public Rejection(Object value, @NonNull String message) {
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
