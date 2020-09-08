package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getSizeOf;

/**
 * This {@link Predicate} matches the <i>magnitude</i> of values that are
 * <b>greater than</b> a given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeGreaterThanPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Instantiates a new {@code AssertSizeGreaterThan} to match the
     * <i>magnitude</i> of values that are <b>greater than</b> {@code size}.
     *
     * @param size The size to test equality against
     */
    public AssertSizeGreaterThan(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertSizeLessThanOrEqualTo(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s > size).isPresent();
    }
}
