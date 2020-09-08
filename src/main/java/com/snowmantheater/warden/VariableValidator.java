package com.snowmantheater.warden;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class VariableValidator implements Validator {
    private final String name;
    private final Object value;

    public VariableValidator(String name, Object value) {
        this.name = requireNonNull(name, "name is null");
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public ValidatorActions is(Predicate<Object> predicate) {
        Messages messages = new VariableMessages(name, value);
        boolean matching = predicate.test(value);
        return new ValidatorActions(value, matching, messages);
    }
}
