package com.snowmantheater.warden;

/**
 * This class provides the basic compounding methods for generating messages
 * used in the validator process.
 */
public abstract class AbstractMessages implements Messages {

    /**
     * Let's a subclass establish what the prefix should be for all messages.
     *
     * @return The message prefix
     */
    public abstract String getMessagePrefix();

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return getMessagePrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(String reason) {
        return getMessagePrefix() + ": " + reason;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(Throwable cause) {
        return getMessagePrefix() + ": " + cause.getMessage();
    }
}
