package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link SizeGreaterThanPredicate} matches values that have <i>magnitude</i> and their size is <b>greater than</b> a
 * given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeGreaterThanPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Creates a new {@link SizeGreaterThanPredicate} matching values with size <b>greater than</b> {@code size}.
     *
     * @param size The size to test equality against
     */
    SizeGreaterThanPredicate(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     *
     * @see SizeLessThanOrEqualToPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new SizeLessThanOrEqualToPredicate(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s > size).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof SizeGreaterThanPredicate &&
            Objects.equals(size, ((SizeGreaterThanPredicate) other).size);
    }
}
