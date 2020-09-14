package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateTestHelper {
    /** Used to verify all predicate results are {@code true} using {@code allMatch()} */
    public static final Predicate<Boolean> TRUE = result -> result;

    /** Used to verify all predicate results are {@code false} using {@code allMatch()} */
    public static final Predicate<Boolean> FALSE = result -> !result;

    /**
     * Returns a new {@link PredicateApplier} that can easily apply {@code predicate} to given values.
     *
     * @param predicate The Predicate to apply
     *
     * @return A PredicateApplier for {@code predicate}.
     */
    public static PredicateApplier apply(Predicate<Object> predicate) {
        return new PredicateApplier(predicate);
    }

    /**
     * {@link PredicateApplier} applies a given {@link Predicate} to given values.
     */
    static class PredicateApplier {
        private final Predicate<Object> predicate;

        /**
         * Create a new {@link PredicateApplier} for {@code predicate}.
         *
         * @param predicate The given Predicate to apply
         */
        PredicateApplier(Predicate<Object> predicate) {
            this.predicate = predicate;
        }

        /**
         * Assists in passing a single array as a single element to the {@code to()} method.
         *
         * @param value The single value to pass
         *
         * @return The results of the application as a Stream
         */
        Stream<Boolean> toOne(Object value) {
            return to(value);
        }

        /**
         * Apply {@code predicate} to {@code values} returning a {@link Stream<Boolean>} of the results.
         *
         * @param values The values to apply Predicate to
         *
         * @return The results of the application as a Stream
         */
        Stream<Boolean> to(Object... values) {
            return Stream.of(values).map(predicate::test);
        }
    }
}

