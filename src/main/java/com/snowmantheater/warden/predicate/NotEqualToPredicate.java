package com.snowmantheater.warden.predicate;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * {@link NotEqualToPredicate} matches values that do <b>not equal</b> a given instance. If both the value and instance
 * are arrays then {@link Arrays#equals} is used otherwise {@link Objects#equals}.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class NotEqualToPredicate implements Predicate<Object> {
    private final Object object;

    /**
     * Creates a new {@link NotEqualToPredicate} matching values <b>not equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     */
    NotEqualToPredicate(Object object) {
        this.object = object;
    }

    /**
     * {@inheritDoc}
     *
     * @see EqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new EqualToPredicate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        if(object instanceof Object[] && t instanceof Object[]) {
            return !Arrays.equals((Object[])object, (Object[])t);
        }

        if(object instanceof boolean[] && t instanceof boolean[]) {
            return !Arrays.equals((boolean[])object, (boolean[])t);
        }

        if(object instanceof byte[] && t instanceof byte[]) {
            return !Arrays.equals((byte[])object, (byte[])t);
        }

        if(object instanceof char[] && t instanceof char[]) {
            return !Arrays.equals((char[])object, (char[])t);
        }

        if(object instanceof double[] && t instanceof double[]) {
            return !Arrays.equals((double[])object, (double[])t);
        }

        if(object instanceof float[] && t instanceof float[]) {
            return !Arrays.equals((float[])object, (float[])t);
        }

        if(object instanceof int[] && t instanceof int[]) {
            return !Arrays.equals((int[])object, (int[])t);
        }

        if(object instanceof long[] && t instanceof long[]) {
            return !Arrays.equals((long[])object, (long[])t);
        }

        if(object instanceof short[] && t instanceof short[]) {
            return !Arrays.equals((short[])object, (short[])t);
        }

        return !Objects.equals(t, object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof NotEqualToPredicate && Objects.equals(object, ((NotEqualToPredicate)other).object);
    }
}
