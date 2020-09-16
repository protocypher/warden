package com.snowmantheater.warden;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class FieldValidator implements Validator {
    private final String name;
    private final Object value;

    FieldValidator(String name, Object value) {
        this.name = requireNonNull(name);
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PredicateActions matches(Predicate<Object> predicate) {
        if(predicate.test(value)) {
            return new MatchingPredicateActions(name, value);
        } else {
            return new NonMatchingPredicateActions(name, value);
        }
    }
}
