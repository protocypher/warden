package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link SizeNotEqualToPredicate} matches values that have <i>magnitude</i> and their size is <b>not equal</b> to a
 * given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeNotEqualToPredicate implements Predicate<Object> {
    private final int size;

    /* PACKAGE LOCKED */
    SizeNotEqualToPredicate(int size) {
        this.size = size;
    }

    /**
     * Creates a new {@link SizeNotEqualToPredicate} matching values with size <b>not equal</b> {@code size}.
     *
     * @param size The size to test against
     */
    public static SizeNotEqualToPredicate SzNotEqualTo(int size) {
        return new SizeNotEqualToPredicate(size);
    }

    /**
     * <i>(shorthand)</i> Creates a new {@link SizeNotEqualToPredicate} matching values with size <b>not equal</b>
     * {@code size}.
     *
     * @param size The size to test against
     */
    public static SizeNotEqualToPredicate zne(int size) {
        return SzNotEqualTo(size);
    }

    /**
     * {@inheritDoc}
     *
     * @see SizeEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new SizeEqualToPredicate(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s != size).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof SizeNotEqualToPredicate && Objects.equals(size, ((SizeNotEqualToPredicate) other).size);
    }
}
