package com.snowmantheater.warden;

import java.util.function.Consumer;

/**
 * {@link MatchingPredicateActions} implements the methods of {@code PredicateActions} as if the value does not match
 * the {@code Predicate}.
 */
class NonMatchingPredicateActions extends AbstractPredicateActions {

    /**
     * Creates a new {@link NonMatchingPredicateActions} for {@code value}.
     *
     * @param value The given value
     */
    NonMatchingPredicateActions(Object value) {
        super(value, MessageProvider.of(value));
    }

    /**
     * Creates a new {@link NonMatchingPredicateActions} for {@code value} named {@code name}.
     *
     * @param name The name of the value
     * @param value The given value
     */
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
