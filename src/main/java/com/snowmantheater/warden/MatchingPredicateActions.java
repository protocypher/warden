package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

class MatchingPredicateActions extends AbstractPredicateActions {

    MatchingPredicateActions(Object value) {
        super(value, MessageProvider.of(value));
    }

    MatchingPredicateActions(String name, Object value) {
        super(value, MessageProvider.of(name, value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reject() {
        throw new RejectionException(getValue(), getMessageProvider().getRejectingMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reject(String reason) {
        throw new RejectionException(getValue(), getMessageProvider().getRejectingMessage(reason));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <X extends Throwable> void raise(Supplier<? extends X> supplier) throws X {
        throw supplier.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform(Consumer<Object> action) {
        action.accept(getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void performOrElse(Consumer<Object> action, Consumer<Object> altAction) {
        action.accept(getValue());
    }
}
