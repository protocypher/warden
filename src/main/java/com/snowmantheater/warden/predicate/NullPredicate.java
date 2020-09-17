package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

/**
 * {@link NullPredicate} matches values that are <i>nullable</i> and are <b>null</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class NullPredicate implements Predicate<Object> {

    /**
     * Creates a new {@link NullPredicate} matching values that are <b>null</b>.
     */
    NullPredicate() { }

    /**
     * {@inheritDoc}
     *
     * @see NotNullPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new NotNullPredicate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return t == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof NullPredicate;
    }
}
