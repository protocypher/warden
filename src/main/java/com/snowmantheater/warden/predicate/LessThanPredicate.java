package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getComparableOf;
import static java.util.Objects.requireNonNull;

/**
 * {@link LessThanPredicate} matches values that are {@link Comparable} with and <b>less than</b> a given instance.
 *
 * @author benjamin@snowmantheater.com
 */
public class LessThanPredicate implements Predicate<Object> {
    private final Object object;

    /**
     * Creates a new {@link LessThanPredicate} matching values <b>less than</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public LessThanPredicate(Object object) {
        this.object = requireNonNull(object, "object is null");
    }

    /**
     * {@inheritDoc}
     *
     * @see GreaterThanOrEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new GreaterThanOrEqualToPredicate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        try {
            return getComparableOf(t).filter(c -> c.compareTo(object) < 0).isPresent();
        } catch(ClassCastException ignored) {
            return false;
        }
    }
}
