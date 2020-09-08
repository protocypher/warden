package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

/**
 * This {@link Predicate} matches values that are <i>nullable</i> and are <b>not
 * null</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class NotNullPredicate implements Predicate<Object> {

    /**
     * {@inheritDoc}
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
