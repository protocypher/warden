package com.snowmantheater.warden;

public final class Validators {
    private Validators() {}

    public static Validator when(Object value) {
        return new ValueValidator(value);
    }

    public static Validator when(String name, Object value) {
        return new VariableValidator(name, value);
    }
}
