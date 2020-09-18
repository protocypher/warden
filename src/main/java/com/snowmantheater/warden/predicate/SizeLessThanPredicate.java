package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link SizeLessThanPredicate} matches values that have <i>magnitude</i> and their size is <b>less than</b> a given
 * size.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class SizeLessThanPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Creates a new {@link SizeLessThanPredicate} matching values with size <b>less than</b> {@code size}.
     *
     * @param size The size to test against
     */
    SizeLessThanPredicate(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     *
     * @see SizeGreaterThanOrEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new SizeGreaterThanOrEqualToPredicate(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s < size).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof SizeLessThanPredicate && Objects.equals(size, ((SizeLessThanPredicate)other).size);
    }
}
