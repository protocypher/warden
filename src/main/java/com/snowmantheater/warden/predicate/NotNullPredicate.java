package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

/**
 * {@link NotNullPredicate} matches values that are <i>nullable</i> and are <b>not null</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class NotNullPredicate implements Predicate<Object> {

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
}
