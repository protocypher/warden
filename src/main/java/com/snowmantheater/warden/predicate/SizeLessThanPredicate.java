package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getSizeOf;

/**
 * This {@link Predicate} matches the <i>magnitude</i> of values that are
 * <b>less than</b> a given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeLessThanPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Instantiates a new {@code AssertSizeLessThan} to match the
     * <i>magnitude</i> of values that are <b>less than</b> {@code size}.
     *
     * @param size The size to test equality against
     */
    public AssertSizeLessThan(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertSizeGreaterThanOrEqualTo(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s < size).isPresent();
    }
}
