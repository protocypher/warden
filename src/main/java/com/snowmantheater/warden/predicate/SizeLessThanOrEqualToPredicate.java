package com.snowmantheater.warden.predicate;

import java.util.Objects;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link SizeLessThanOrEqualToPredicate} matches values that have <i>magnitude</i> and their size is <b>less than or
 * equal to</b> a given size.
 *
 * @author benjamin@snowmantheater.com
 * @version 1.0.0
 */
public class SizeLessThanOrEqualToPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Creates a new {@link SizeLessThanOrEqualToPredicate} matching values with size <b>less than or equal to</b>
     * {@code size}.
     *
     * @param size The size to test against
     */
    SizeLessThanOrEqualToPredicate(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     *
     * @see SizeGreaterThanPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new SizeGreaterThanPredicate(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s <= size).isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof SizeLessThanOrEqualToPredicate &&
              Objects.equals(size, ((SizeLessThanOrEqualToPredicate)other).size);
    }
}
