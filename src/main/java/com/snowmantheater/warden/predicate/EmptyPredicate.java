package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

/**
 * {@link EmptyPredicate} matches values that have <i>magnitude</i>, are not null and are <b>empty</b>.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class EmptyPredicate implements Predicate<Object> {

    /**
     * Creates a new {@link EmptyPredicate} matching values that are <b>empty</b>.
     */
    EmptyPredicate() { }

    /**
     * {@inheritDoc}
     *
     * @see NotEmptyPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new NotEmptyPredicate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return Util.getSizeOf(t).filter(s -> s == 0).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof EmptyPredicate;
    }
}
