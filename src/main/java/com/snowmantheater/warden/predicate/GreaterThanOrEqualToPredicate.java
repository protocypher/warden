package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getComparableOf;
import static java.util.Objects.requireNonNull;

/**
 * {@link GreaterThanOrEqualToPredicate} matches values that are {@link Comparable} with and <b>greater than or equal
 * to</b> a given instance.
 *
 * @author benjamin@snowmantheater.com
 */
public class GreaterThanOrEqualToPredicate implements Predicate<Object> {
    private final Object object;

    /* PACKAGE LOCKED */
    GreaterThanOrEqualToPredicate(Object object) {
        this.object = requireNonNull(object, "object is null");
    }

    /**
     * Creates a new {@link GreaterThanOrEqualToPredicate} matching values <b>greater than or equals to</b>
     * {@code object}.
     *
     * @param object The given instance to test against
     */
    public static GreaterThanOrEqualToPredicate GreaterThanOrEqualTo(Object object) {
        return new GreaterThanOrEqualToPredicate(object);
    }

    /**
     * <i>(shorthand)</i> Creates a new {@link GreaterThanOrEqualToPredicate} matching values <b>greater than or equals
     * to</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public static GreaterThanOrEqualToPredicate ge(Object object) {
        return GreaterThanOrEqualTo(object);
    }

    /**
     * <i>(alternate)</i> Creates a new {@link GreaterThanOrEqualToPredicate} matching values <b>after or at</b>
     * {@code object}.
     *
     * @param object The given instance to test against
     */
    public static GreaterThanOrEqualToPredicate AfterOrAt(Object object) {
        return GreaterThanOrEqualTo(object);
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
        } catch(ClassCastException ignored) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof GreaterThanOrEqualToPredicate &&
            Objects.equals(object, ((GreaterThanOrEqualToPredicate) other).object);
    }
}
