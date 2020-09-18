package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * {@link AbstractPredicateActions} provides basic implementations of the {@link PredicateActions} to keep implementors
 * consistent.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
abstract class AbstractPredicateActions implements PredicateActions {
    private final Object value;
    private final MessageProvider messageProvider;

    /**
     * Creates a new {@link AbstractPredicateActions} for the {@code value} and {@code messageProvider}.
     *
     * @param value The given value
     * @param messageProvider The given MessageProvider
     */
    protected AbstractPredicateActions(Object value, MessageProvider messageProvider) {
        this.value = value;
        this.messageProvider = messageProvider;
    }

    /**
     * Provides access for the implementor to the value that was used to create this {@link AbstractPredicateActions}.
     *
     * @return The value which was validated
     */
    protected Object getValue() {
        return value;
    }

    /**
     * Provides access for the implementor to the {@link MessageProvider} that was used to create this
     * {@link AbstractPredicateActions}.
     *
     * @return The MessageProvider for this instance
     */
    protected MessageProvider getMessageProvider() {
        return messageProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reject() { }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reject(String reason) { }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept() { }

    /**
     * {@inheritDoc}
     */
    @Override
    public <X extends Throwable> void raise(Supplier<? extends X> supplier) throws X { }

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform(Consumer<Object> action) { }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logReject(Consumer<String> logAdapter) {
        logAdapter.accept(messageProvider.getRejectingMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logReject(String reason, Consumer<String> logAdapter) {
        logAdapter.accept(messageProvider.getRejectingMessage(reason));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logAccept(Consumer<String> logAdapter) {
        logAdapter.accept(messageProvider.getAcceptingMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logAccept(String reason, Consumer<String> logAdapter) {
        logAdapter.accept(messageProvider.getAcceptingMessage(reason));
    }
}
