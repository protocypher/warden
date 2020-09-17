package com.snowmantheater.warden;

import static java.util.Objects.requireNonNull;

/**
 * {@link AbstractMessageProvider} provides the common, basic behavior for all {@link MessageProvider}s.
 */
abstract class AbstractMessageProvider implements MessageProvider {
    private final String base;

    /**
     * Creates a new {@link AbstractMessageProvider} to build messages off of {@code base}. Expected to be called by
     * implementors.
     *
     * @param base The message base
     */
    protected AbstractMessageProvider(String base) {
        this.base = base;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRejectingMessage() {
        return "Rejecting " + base + ".";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRejectingMessage(String reason) {
        return "Rejecting " + base + ": " + requireNonNull(reason);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAcceptingMessage() {
        return "Accepting " + base + ".";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAcceptingMessage(String reason) {
        return "Accepting " + base + ": " + requireNonNull(reason);
    }
}
