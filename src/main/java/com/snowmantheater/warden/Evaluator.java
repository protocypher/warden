package com.snowmantheater.warden;

import java.util.function.Predicate;

/**
 * This class wraps a given value and provides a method for evaluating
 * predicates against it.
 */
public class Evaluator {
    private final Object value;

    /**
     * Instantiates a new {@code Evaluator} to evaluate {@code value}.
     *
     * @param value The given value to evaluate
     */
    public Evaluator(Object value) {
        this.value = value;
    }

    /**
     * Evaluates {@code value} against {@code predicate}.
     *
     * @param predicate The given predicate
     *
     * @return Whether {@code predicate} matches {@code value}
     */
    public boolean is(Predicate<Object> predicate) {
        return predicate.test(value);
    }
}
