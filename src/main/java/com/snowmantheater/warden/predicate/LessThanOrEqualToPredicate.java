package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getComparableOf;
import static java.util.Objects.requireNonNull;

/**
 * {@link LessThanOrEqualToPredicate} matches values that are {@link Comparable} with and <b>less than or equal to</b> a
 * given instance.
 *
 * @author benjamin@snowmantheater.com
 */
public class LessThanOrEqualToPredicate implements Predicate<Object> {
    private final Object object;

    /**
     * Creates a new {@link LessThanOrEqualToPredicate} matching values <b>less than or equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    LessThanOrEqualToPredicate(Object object) {
        this.object = requireNonNull(object, "object is null");
    }

    /**
     * {@inheritDoc}
     *
     * @see GreaterThanPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new GreaterThanPredicate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        try {
            return getComparableOf(t).filter(c -> c.compareTo(object) <= 0).isPresent();
        } catch(ClassCastException ignored) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof LessThanOrEqualToPredicate &&
            Objects.equals(object, ((LessThanOrEqualToPredicate) other).object);
    }
}
