package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

abstract class AbstractPredicateActions implements PredicateActions {
    private final Object value;
    private final MessageProvider messageProvider;

    protected AbstractPredicateActions(Object value, MessageProvider messageProvider) {
        this.value = value;
        this.messageProvider = messageProvider;
    }

    protected Object getValue() {
        return value;
    }

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
