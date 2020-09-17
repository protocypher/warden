package com.snowmantheater.warden;

import java.util.function.Predicate;

/**
 * A {@link ValueValidator} is a {@link Validator} for a nameless value.
 *
 * @see Validator
 */
class ValueValidator implements Validator {
    private final Object value;

    /**
     * Create a new validator which operates on {@code value}
     *
     * @param value The value to validate
     */
    ValueValidator(Object value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PredicateActions is(Predicate<Object> predicate) {
        if(predicate.test(value)) {
            return new MatchingPredicateActions(value);
        } else {
            return new NonMatchingPredicateActions(value);
        }
    }
}
