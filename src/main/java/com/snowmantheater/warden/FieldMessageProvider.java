package com.snowmantheater.warden;

import static java.util.Objects.requireNonNull;

/**
 * A {@link FieldMessageProvider} provides messages for a named value.
 */
class FieldMessageProvider extends AbstractMessageProvider {
    /**
     * Creates a new {@link FieldMessageProvider} for {@code value} named {@code name}.
     *
     * @param name The name of the value
     * @param value The given value
     */
    FieldMessageProvider(String name, Object value) {
        super(requireNonNull(name) + "='" + value + "'");
    }
}
