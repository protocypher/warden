package com.snowmantheater.warden;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

/**
 * A {@link FieldValidator} is a {@link Validator} for a named value.
 *
 * @see Validator
 */
public class FieldValidator implements Validator {
    private final String name;
    private final Object value;

    /**
     * Create a new validator which operates on {@code value}
     *
     * @param name The name of the value
     * @param value The value to validate
     */
    FieldValidator(String name, Object value) {
        this.name = requireNonNull(name);
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PredicateActions is(Predicate<Object> predicate) {
        if(predicate.test(value)) {
            return new MatchingPredicateActions(name, value);
        } else {
            return new NonMatchingPredicateActions(name, value);
        }
    }
}
