package com.snowmantheater.warden;

import java.util.function.Consumer;

class NonMatchingPredicateActions extends AbstractPredicateActions {

    NonMatchingPredicateActions(Object value) {
        super(value, MessageProvider.of(value));
    }

    NonMatchingPredicateActions(String name, Object value) {
        super(value, MessageProvider.of(name, value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept() {
        throw new RejectionException(getValue(), getMessageProvider().getRejectingMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void performOrElse(Consumer<Object> action, Consumer<Object> altAction) {
        altAction.accept(getValue());
    }
}
