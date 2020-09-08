package com.snowmantheater.warden;

/**
 * This class provides messages about nameless values.
 */
public class ValueMessages extends AbstractMessages implements Messages {
    private final Object value;

    /**
     * Instantiates a new {@code ValueMessages} to produce messages about
     * {@code value}.
     *
     * @param value The topic of the messages
     */
    public ValueMessages(Object value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessagePrefix() {
        return "Rejecting '" + value + "'";
    }
}
