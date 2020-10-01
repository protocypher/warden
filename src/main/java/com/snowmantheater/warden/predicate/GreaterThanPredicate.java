package com.snowmantheater.warden.predicate;

import lombok.NonNull;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getComparableOf;

/**
 * {@link GreaterThanPredicate} matches values that are {@link Comparable} with and <b>greater than</b> a given
 * instance.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class GreaterThanPredicate implements Predicate<Object> {
    private final Object object;

    /**
     * Creates a new {@link GreaterThanPredicate} matching values <b>greater than</b> {@code object}.
     *
     * @param object (non-null) The given instance to test against
     */
    GreaterThanPredicate(@NonNull Object object) {
        this.object = object;
    }

    /**
     * {@inheritDoc}
     *
     * @see LessThanOrEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new LessThanOrEqualToPredicate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        try {
            return getComparableOf(t).filter(c -> c.compareTo(object) > 0).isPresent();
        } catch(ClassCastException ignored) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof GreaterThanPredicate && Objects.equals(object, ((GreaterThanPredicate) other).object);
    }
}
