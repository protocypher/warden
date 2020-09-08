package com.snowmantheater.warden;

import java.util.function.Predicate;

/**
 * This class holds a value to be evaluated and returns {@link ValidatorActions}
 * that can operate on simple values once given a {@link Predicate}.
 */
public class ValueValidator implements Validator {
    private final Object value;

    /**
     * Instantiates a new {@code ValueValidator} to validate {@code value}.
     *
     * @param value The value to validate
     */
    public ValueValidator(Object value) {
        this.value = value;
    }

    /**
     * Returns the value being validated.
     *
     * @return The value being validated
     */
    public Object getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ValidatorActions is(Predicate<Object> predicate) {
        Messages messages = new ValueMessages(value);
        boolean matching = predicate.test(value);
        return new ValidatorActions(value, matching, messages);
    }
}
