package com.snowmantheater.warden.predicate;

import lombok.NonNull;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getComparableOf;

/**
 * {@link GreaterThanOrEqualToPredicate} matches values that are {@link Comparable} with and <b>greater than or equal
 * to</b> a given instance.
 *
 * @author benjamin@snowmantheater.com
 * @version 1.0.0
 */
public class GreaterThanOrEqualToPredicate implements Predicate<Object> {
    private final Object object;

    /**
     * Creates a new {@link GreaterThanOrEqualToPredicate} matching values <b>greater than or equal to</b>
     * {@code object}.
     *
     * @param object The given instance to test against
     */
    GreaterThanOrEqualToPredicate(@NonNull Object object) {
        this.object = object;
    }

    /**
     * {@inheritDoc}
     *
     * @see LessThanPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new LessThanPredicate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        try {
            return getComparableOf(t).filter(c -> c.compareTo(object) >= 0).isPresent();
        } catch (ClassCastException ignored) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof GreaterThanOrEqualToPredicate &&
              Objects.equals(object, ((GreaterThanOrEqualToPredicate)other).object);
    }
}
