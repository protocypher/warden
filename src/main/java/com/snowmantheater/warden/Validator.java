package com.snowmantheater.warden;

import lombok.NonNull;

import java.util.function.Predicate;

import static com.snowmantheater.warden.Value.of;

/**
 * A {@link Validator} validates a value with given {@link Predicate}s and provides appropriate {@link Actions}
 * based on whether the value matches.
 *
 * @see Predicate
 * @see Actions
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class Validator {
    private final Value value;

    /**
     * Create a new {@link Validator} for {@code value}.
     *
     * @param value The ValidationValue to evaluate
     */
    private Validator(Value value) {
        this.value = value;
    }

    /**
     * Returns a {@link Validator} to evaluate {@code value}.
     *
     * @param value The value to evaluate
     *
     * @return A Validator
     */
    public static Validator when(Object value) {
        return new Validator(of(value));
    }

    /**
     * Returns a {@link Validator} to evaluate {@code value} named {@code name}.
     *
     * @param name (non-null)The name of the value
     * @param value The value to evaluate
     *
     * @return A Validator
     */
    public static Validator when(@NonNull String name, Object value) {
        return new Validator(of(name, value));
    }

    /**
     * Returns a {@link Validator} to evaluate {@code value} named {@code name} inside {@code parent}.
     *
     * @param parent (non-null) The parent of the value
     * @param name (non-null) The name of the value
     * @param value The value to evaluate
     *
     * @return A Validator
     */
    public static Validator when(@NonNull Object parent, @NonNull String name, Object value) {
        return new Validator(of(parent, name, value));
    }

    /**
     * Returns a {@link Actions} which behaves according to whether {@code value} matches {@code predicate}.
     *
     * @param predicate (non-null) The Predicate to test with
     *
     * @return A PredicateActions which behaves according to the result of predicate
     */
    public Actions is(@NonNull Predicate<Object> predicate) {
        return new Actions(value, predicate);
    }
}
