package com.snowmantheater.warden;

/**
 * {@link MessageProvider} provides messages for a given (named) value.
 */
public interface MessageProvider {
    /**
     * Returns a {@link MessageProvider} which provides messages for {@code value}.
     *
     * @param value The given value
     *
     * @return A MessageProvider which provides messages for value
     */
    static MessageProvider of(Object value) {
        return new ValueMessageProvider(value);
    }

    /**
     * Returns a {@link MessageProvider} which provides messages for {@code value} names {@code name}.
     *
     * @param name The name of the value
     * @param value The given value
     *
     * @return A MessageProvider which provides messages for value named name
     */
    static MessageProvider of(String name, Object value) {
        return new FieldMessageProvider(name, value);
    }

    /**
     * Returns the basic, rejection message.
     *
     * @return The basic, rejection message
     */
    String getRejectingMessage();

    /**
     * Returns a rejection message with {@code reason} embedded.
     *
     * @param reason The rejection reason
     *
     * @return A rejection message with reason embedded
     */
    String getRejectingMessage(String reason);

    /**
     * Returns the basic, accepting message.
     *
     * @return The basic, accepting message
     */
    String getAcceptingMessage();

    /**
     * Returns a accepting message with {@code reason} embedded.
     *
     * @param reason The accepting reason
     *
     * @return A accepting message with reason embedded
     */
    String getAcceptingMessage(String reason);
}
