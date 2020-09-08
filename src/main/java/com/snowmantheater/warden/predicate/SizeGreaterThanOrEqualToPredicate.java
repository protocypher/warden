package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getSizeOf;

/**
 * This {@link Predicate} matches the <i>magnitude</i> of values that are
 * <b>greater than or equal to</b> a given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeGreaterThanOrEqualToPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Instantiates a new {@code AssertSizeGreaterThanOrEqualTo} to match the
     * <i>magnitude</i> of values that are <b>greater than or equal to</b>
     * {@code size}.
     *
     * @param size The size to test equality against
     */
    public AssertSizeGreaterThanOrEqualTo(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertSizeLessThan(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s >= size).isPresent();
    }
}
