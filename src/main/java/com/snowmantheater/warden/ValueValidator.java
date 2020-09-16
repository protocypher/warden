package com.snowmantheater.warden;

import java.util.function.Predicate;

class ValueValidator implements Validator {
    private final Object value;

    ValueValidator(Object value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PredicateActions matches(Predicate<Object> predicate) {
        if(predicate.test(value)) {
            return new MatchingPredicateActions(value);
        } else {
            return new NonMatchingPredicateActions(value);
        }
    }
}
