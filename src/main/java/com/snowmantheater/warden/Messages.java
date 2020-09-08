package com.snowmantheater.warden;

/**
 * Classes of this type should provide messages as needed for validator steps.
 */
public interface Messages {

    /**
     * Returns a minimal, meaningful message for use in validation.
     *
     * @return A minimal, meaningful message
     */
    String getMessage();

    /**
     * Returns a message with the given reason embedded in it.
     *
     * @param reason The given reason
     *
     * @return A message with the given reason
     */
    String getMessage(String reason);

    /**
     * Returns a message with the message of {@code cause} embedded in it.
     *
     * @param cause The Throwable to retrieve the message from
     *
     * @return A message with the message of {@code cause}
     *
     * @throws NullPointerException If {@code cause} is null
     */
    String getMessage(Throwable cause);
}
