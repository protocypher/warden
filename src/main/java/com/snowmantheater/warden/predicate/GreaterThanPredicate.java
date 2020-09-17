package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getComparableOf;
import static java.util.Objects.requireNonNull;

/**
 * {@link GreaterThanPredicate} matches values that are {@link Comparable} with and <b>greater than</b> a given
 * instance.
 *
 * @author benjamin@snowmantheater.com
 */
public class GreaterThanPredicate implements Predicate<Object> {
    private final Object object;

    /* PACKAGE LOCKED */
    GreaterThanPredicate(Object object) {
        this.object = requireNonNull(object, "object is null");
    }

    /**
     * Creates a new {@link GreaterThanPredicate} matching values <b>greater than</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public static GreaterThanPredicate GreaterThan(Object object) {
        return new GreaterThanPredicate(object);
    }

    /**
     * <i>(shorthand)</i> Creates a new {@link GreaterThanPredicate} matching values <b>greater than</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public static GreaterThanPredicate gt(Object object) {
        return GreaterThan(object);
    }

    /**
     * <i>(alternate)</i> Creates a new {@link GreaterThanPredicate} matching values <b>after</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public static GreaterThanPredicate After(Object object) {
        return GreaterThan(object);
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
