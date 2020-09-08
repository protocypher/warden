package com.snowmantheater.warden;

import java.util.function.Predicate;

public class VariableValidator implements Validator {
    private final String name;
    private final Object value;

    public VariableValidator(String name, Object value) {
        if(name == null) {
            throw new IllegalArgumentException("`name` cannot be null");
        }

        this.name = name;
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
