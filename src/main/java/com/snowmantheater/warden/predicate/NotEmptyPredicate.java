package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getSizeOf;

/**
 * This {@link Predicate} matches values that have <i>magnitude</i> and are
 * neither null or <b>empty</b>.
 *
 * @author benjamin@snowmantheater.com
 */
public class NotEmptyPredicate implements Predicate<Object> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s != 0).isPresent();
    }
}
