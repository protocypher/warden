package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

/**
 * {@link NotNullPredicate} matches values that are <i>nullable</i> and are <b>not null</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class NotNullPredicate implements Predicate<Object> {

    /* PACKAGE LOCKED */
    NotNullPredicate() { }

    /**
     * Creates a new {@link NotNullPredicate} matching values that are <b>not null</b>.
     *
     * @return A new NotNullPredicate
     */
    public static NotNullPredicate NotNull() {
        return new NotNullPredicate();
    }

    /**
     * {@inheritDoc}
     *
     * @see NullPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new NullPredicate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return t != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof NotNullPredicate;
    }
}
