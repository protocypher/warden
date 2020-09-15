package com.snowmantheater.warden;

/**
 * {@link RejectionException}s are thrown when values cannot be accepted or are explicitly rejected.
 */
public class RejectionException extends RuntimeException {
    private final Object value;

    /**
     * Creates a new {@link RejectionException} with the rejected value and the reason message.
     *
     * @param value The rejecting value
     * @param message The reason message
     */
    public RejectionException(Object value, String message) {
        super(message);
        this.value = value;
    }

    /**
     * Creates a new {@link RejectionException} with the rejected value, the reason message and the cause.
     *
     * @param value The rejected value
     * @param message The reason message
     * @param cause The cause
     */
    public RejectionException(Object value, String message, Throwable cause) {
        super(message, cause);
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
