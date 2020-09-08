package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getSizeOf;

/**
 * This {@link Predicate} matches values that have <i>magnitude</i>, are not
 * null but are <b>empty</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class EmptyPredicate implements Predicate<Object> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertNotEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s == 0).isPresent();
    }
}
