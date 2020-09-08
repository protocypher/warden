package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getComparableOf;

/**
 * This {@link Predicate} matches values that are {@link Comparable} with a
 * given instance and are <b>less than or equal to</b> it.
 *
 * @author benjamin@snowmantheater.com
 */
public class LessThanOrEqualToPredicate implements Predicate<Object> {
    private final Object object;

    /**
     * Instantiates a new {@code AssertLessThanOrEqualTo} to compare values with
     * {@code object}.
     *
     * @param object The instance compare with
     */
    public AssertLessThanOrEqualTo(Object object) {
        if(object == null) {
            throw new IllegalArgumentException("`object` cannot be NULL");
        }

        this.object = object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertGreaterThan(object);
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
}
