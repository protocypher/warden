package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

/**
 * {@link EmptyPredicate} matches values that have <i>magnitude</i>, are not null and are <b>empty</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class EmptyPredicate implements Predicate<Object> {

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
}
