package com.snowmantheater.warden;

import lombok.Getter;
import lombok.NonNull;

/**
 * Represents a value being validated with a possible name and parent class. A {@link Value} can represent a variable,
 * parameter, argument, field or property.
 *
 * @author benjamin@snowmantheater.com
 * @version 1.0.0
 */
class Value {
    private enum Type {FIELD, VARIABLE, VALUE}

    @Getter
    private final Object value;
    private final Object parent;
    private final String name;
    private final Type type;

    /**
     * A private, controlled constructor which can only receive specific combinations of null values.
     *
     * @param parent The parent instance
     * @param name The name fo the value
     * @param value The actual value
     */
    private Value(Object parent, String name, Object value) {
        this.parent = parent;
        this.name = name;
        this.value = value;

        if (parent == null && name == null) {
            type = Type.VALUE;
        } else if (parent == null) {
            type = Type.VARIABLE;
        } else {
            type = Type.FIELD;
        }
    }

    /**
     * Creates a new value with a name and parent instance. This can be a property or field.
     *
     * @param parent The parent instance
     * @param name The name of the value
     * @param value The actual value
     *
     * @return A new ValidationValue
     */
    public static Value of(@NonNull Object parent, @NonNull String name, Object value) {
        return new Value(parent, name, value);
    }

    /**
     * Creates a new value with a name. This can be an argument or parameter.
     *
     * @param name The name of the value
     * @param value The actual value
     *
     * @return A new ValidationValue
     */
    public static Value of(@NonNull String name, Object value) {
        return new Value(null, name, value);
    }

    /**
     * Creates a new value. This can be a nameless return value or result.
     *
     * @param value The actual value
     *
     * @return A new ValidationValue
     */
    public static Value of(Object value) {
        return new Value(null, null, value);
    }

    /**
     * A {@link Value} is a field (or property) if it has a name and parent instance.
     *
     * @return Whether this value is a field
     */
    public boolean isField() {
        return type == Type.FIELD;
    }

    /**
     * A {@link Value} is a variable (or argument, parameter) if it has a name. Fields are also variables so
     * this method returns true for those types as well.
     *
     * @return Whether this value is a variable
     */
    public boolean isVariable() {
        return type == Type.VARIABLE || type == Type.FIELD;
    }

    /**
     * All {@link Value}s are values. This method is provided for completeness.
     *
     * @return Whether this value is a value
     */
    public boolean isValue() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        switch (type) {
            case FIELD:
                return parent.getClass().getSimpleName() + "." + name + "=\"" + value + "\"";

            case VARIABLE:
                return name + "=\"" + value + "\"";

            default:
                return "\"" + value + "\"";
        }
    }
}
