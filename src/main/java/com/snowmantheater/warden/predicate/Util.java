package com.snowmantheater.warden.predicate;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Provides common, utility methods for the {@code warden.predicate} package.
 */
class Util {

    /**
     * If {@code value} is an instance of {@link Comparable} then cast and return {@code value} as one. Otherwise an
     * empty {@link Optional} is returned.
     *
     * @param value The value to cast as a Comparable (if possible)
     *
     * @return {@code value}, cast as a Comparable
     */
    @SuppressWarnings("unchecked")
    static Optional<Comparable<Object>> getComparableOf(Object value) {
        if(value instanceof Comparable) {
            return Optional.of((Comparable<Object>)value);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Returns the size of {@code value} if it has <i>magnitude</i>. Otherwise an empty {@link Optional} is returned.
     *
     * @param value The given value to evaluate the <i>size</i> for
     *
     * @return The size of {@code value} if it has magnitude
     */
    static Optional<Integer> getSizeOf(Object value) {
        if(value == null) { return Optional.empty(); }

        if(value instanceof Collection) { return Optional.of(((Collection<?>)value).size()); }
        if(value instanceof Map) { return Optional.of(((Map<?,?>)value).size()); }
        if(value instanceof CharSequence) { return Optional.of(((CharSequence)value).length()); }
        if(value instanceof Object[]) { return Optional.of(((Object[])value).length); }
        if(value instanceof boolean[]) { return Optional.of(((boolean[])value).length); }
        if(value instanceof byte[]) { return Optional.of(((byte[])value).length); }
        if(value instanceof char[]) { return Optional.of(((char[])value).length); }
        if(value instanceof double[]) { return Optional.of(((double[])value).length); }
        if(value instanceof float[]) { return Optional.of(((float[])value).length); }
        if(value instanceof int[]) { return Optional.of(((int[])value).length); }
        if(value instanceof long[]) { return Optional.of(((long[])value).length); }
        if(value instanceof short[]) { return Optional.of(((short[])value).length); }

        return Optional.empty();
    }
}
