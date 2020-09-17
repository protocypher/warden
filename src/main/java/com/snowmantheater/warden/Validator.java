package com.snowmantheater.warden;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

/**
 * A {@link Validator} validates a value with given {@link Predicate}s and provides appropriate {@link PredicateActions}
 * based on whether the value matches.
 *
 * @see Predicate
 * @see PredicateActions
 */
public interface Validator {

    /**
     * Returns a {@link Validator} which can validate {@code value}.
     *
     * @param value The value to evaluate
     *
     * @return The value
     */
    static Validator when(Object value) {
        return new ValueValidator(value);
    }

    /**
     * Returns a {@link Validator} which validates {@code value} named {@code name}.
     *
     * @param name The name of the value
     * @param value The value to evaluate
     *
     * @return A Validator which validates value named name
     */
    static Validator when(String name, Object value) {
        return new FieldValidator(requireNonNull(name), value);
    }

    /**
     * Returns a {@link PredicateActions} which behaves according to whether {@code value} passes {@code predicate}.
     *
     * @param predicate The Predicate to test with
     *
     * @return A PredicateActions which behaves according to whether value passes predicate
     */
    PredicateActions is(Predicate<Object> predicate);
}
