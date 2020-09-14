package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link SizeNotEqualToPredicate} matches values that have <i>magnitude</i> and their size is <b>equal</b> to a given
 * size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeEqualToPredicate implements Predicate<Object> {
    private final int size;

    /* PACKAGE LOCKED */
    SizeEqualToPredicate(int size) {
        this.size = size;
    }

    /**
     * Creates a new {@link SizeEqualToPredicate} matching values with size <b>equal</b> {@code size}.
     *
     * @param size The size to test against
     */
    public static SizeEqualToPredicate isSizeEqualTo(int size) {
        return new SizeEqualToPredicate(size);
    }

    /**
     * <i>(shorthand)</i> Creates a new {@link SizeEqualToPredicate} matching values with size <b>equal</b>
     * {@code size}.
     *
     * @param size The size to test against
     */
    public static SizeEqualToPredicate zeq(int size) {
        return isSizeEqualTo(size);
    }

    /**
     * {@inheritDoc}
     *
     * @see SizeNotEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new SizeNotEqualToPredicate(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s == size).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object other) {
        return other instanceof SizeEqualToPredicate && Objects.equals(size, ((SizeEqualToPredicate) other).size);
    }
}
