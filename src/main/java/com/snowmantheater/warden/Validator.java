package com.snowmantheater.warden;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public interface Validator {

    static Validator when(Object value) {
        return new ValueValidator(value);
    }

    static Validator when(String name, Object value) {
        return new FieldValidator(requireNonNull(name), value);
    }

    PredicateActions matches(Predicate<Object> predicate);
}
