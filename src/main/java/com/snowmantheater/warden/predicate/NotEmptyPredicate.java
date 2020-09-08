package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link NotEmptyPredicate} matches values that have <i>magnitude</i> and are neither null or <b>empty</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class NotEmptyPredicate implements Predicate<Object> {

    /**
     * {@inheritDoc}
     *
     * @see EmptyPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new EmptyPredicate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s != 0).isPresent();
    }
}
