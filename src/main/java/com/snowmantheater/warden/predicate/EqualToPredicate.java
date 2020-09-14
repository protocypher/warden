package com.snowmantheater.warden.predicate;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * {@link EqualToPredicate} matches values that <b>equal</b> a given instance. If both the value and instance are arrays
 * then {@link Arrays#equals} is used otherwise {@link Objects#equals}.
 *
 * @author benjamin@snowmantheater.com
 */
public class EqualToPredicate implements Predicate<Object> {
    private final Object object;

    /* PACKAGE LOCKED */
    EqualToPredicate(Object object) {
        this.object = object;
    }

    /**
     * Creates a new {@link EqualToPredicate} matching values <b>equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public static EqualToPredicate isEqualTo(Object object) {
        return new EqualToPredicate(object);
    }

    /**
     * <i>(shorthand)</i> Creates a new {@link EqualToPredicate} matching values <b>equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    public static EqualToPredicate eq(Object object) {
        return isEqualTo(object);
    }

    /**
     * {@inheritDoc}
     *
     * @see NotEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new NotEqualToPredicate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        if(object instanceof Object[] && t instanceof Object[]) {
            return Arrays.equals((Object[])object, (Object[])t);
        }

        if(object instanceof boolean[] && t instanceof boolean[]) {
            return Arrays.equals((boolean[])object, (boolean[])t);
        }

        if(object instanceof byte[] && t instanceof byte[]) {
            return Arrays.equals((byte[])object, (byte[])t);
        }

        if(object instanceof char[] && t instanceof char[]) {
            return Arrays.equals((char[])object, (char[])t);
        }

        if(object instanceof double[] && t instanceof double[]) {
            return Arrays.equals((double[])object, (double[])t);
        }

        if(object instanceof float[] && t instanceof float[]) {
            return Arrays.equals((float[])object, (float[])t);
        }

        if(object instanceof int[] && t instanceof int[]) {
            return Arrays.equals((int[])object, (int[])t);
        }

        if(object instanceof long[] && t instanceof long[]) {
            return Arrays.equals((long[])object, (long[])t);
        }

        if(object instanceof short[] && t instanceof short[]) {
            return Arrays.equals((short[])object, (short[])t);
        }

        return Objects.equals(t, object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof EqualToPredicate && Objects.equals(object, ((EqualToPredicate)other).object);
    }
}
