package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.Utils.getSizeOf;

/**
 * This {@link Predicate} matches the <i>magnitude</i> of values that
 * <b>equal</b> a given size.
 *
 * @author benjamin@snowmantheater.com
 */
public class SizeEqualToPredicate implements Predicate<Object> {
    private final int size;

    /**
     * Instantiates a new {@code AssertSizeEqualTo} to match the
     * <i>magnitude</i> of values that <b>equal</b> {@code size}.
     *
     * @param size The size to test equality against
     */
    public AssertSizeEqualTo(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> negate() {
        return new AssertSizeNotEqualTo(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(Object t) {
        return getSizeOf(t).filter(s -> s == size).isPresent();
    }
}
