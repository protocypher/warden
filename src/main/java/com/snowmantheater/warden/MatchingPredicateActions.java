package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * {@link MatchingPredicateActions} implements the methods of {@code PredicateActions} as if the value matches the
 * {@code Predicate}.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
class MatchingPredicateActions extends AbstractPredicateActions {

    /**
     * Creates a new {@link MatchingPredicateActions} for {@code value}.
     *
     * @param value The given value
     */
    MatchingPredicateActions(Object value) {
        super(value, MessageProvider.of(value));
    }

    /**
     * Creates a new {@link MatchingPredicateActions} for {@code value} named {@code name}.
     *
     * @param name The name of the value
     * @param value The given value
     */
    MatchingPredicateActions(String name, Object value) {
        super(value, MessageProvider.of(name, value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reject() {
        throw new ValidationException(getValue(), getMessageProvider().getRejectingMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reject(String reason) {
        throw new ValidationException(getValue(), getMessageProvider().getRejectingMessage(reason));
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
