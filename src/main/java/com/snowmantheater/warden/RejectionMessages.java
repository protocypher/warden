package com.snowmantheater.warden;

import static java.util.Objects.requireNonNull;

/**
 * {@link RejectionMessages} creates contextual, rejection messages for values and variables to be used in logging and
 * exception hierarchies.
 */
public class RejectionMessages {
    private final String prefix;

    /**
     * Create a new {@link RejectionMessages} with the given name and value. The given values are combined to make a
     * message prefix that will be used in the created message.
     */
    private RejectionMessages(String name, Object value) {
        if(name == null) {
            prefix = "Rejecting '" + value + "'";
        } else {
            prefix = "Rejecting " + name + "='" + value + "'";
        }
    }

    /**
     * Returns a {@link RejectionMessages} for the {@code value}.
     *
     * @param value The given value
     *
     * @return A RejectionMessages for value
     */
    public static RejectionMessages of(Object value) {
        return new RejectionMessages(null, value);
    }

    /**
     * Returns a {@link RejectionMessages} for {@code name} and {@code value}.
     *
     * @param name The variable name
     * @param value The given value
     *
     * @return A RejectionMessages for name and value
     *
     * @throws NullPointerException If name is null
     */
    public static RejectionMessages of(String name, Object value) {
        return new RejectionMessages(requireNonNull(name), value);
    }

    /**
     * Creates a basic, meaningful rejection message.
     *
     * @return A basic, meaningful message
     */
    public String create() {
        return prefix + ".";
    }

    /**
     * Creates a message with the given rejection {@code reason} inserted into it.
     *
     * @param reason The rejection reason
     *
     * @return A message with the given rejection reason inserted into it
     *
     * @throws NullPointerException If reason is null
     */
    public String createWith(String reason) {
        return prefix + ": " + requireNonNull(reason);
    }

    /**
     * Creates a message for the given rejection {@code cause} inserted into it.
     *
     * @param cause The rejection cause
     *
     * @return A message with the given rejection cause inserted into it
     *
     * @throws NullPointerException If cause is null
     */
    public String createFor(Throwable cause) {
        return prefix + ": " + requireNonNull(cause).getMessage();
    }
}
