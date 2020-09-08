package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Util.getSizeOf;

/**
 * {@link SizeGreaterThanOrEqualToPredicate} matches values that have <i>magnitude</i> and their size is <b>greater than
 * or equal to</b> a given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeGreaterThanOrEqualToPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Creates a new {@link SizeGreaterThanOrEqualToPredicate} matching values with size <b>greater than or equal to</b>
     * {@code size}.
     *
     * @param size The size to test against
     */
    public SizeGreaterThanOrEqualToPredicate(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     *
     * @see SizeLessThanPredicate
     */
    @Override
    public Predicate<Object> negate() {
        return new SizeLessThanPredicate(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s >= size).isPresent();
    }
}
