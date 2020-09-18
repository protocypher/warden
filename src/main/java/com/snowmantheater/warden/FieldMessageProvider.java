package com.snowmantheater.warden;

import static java.util.Objects.requireNonNull;

/**
 * A {@link FieldMessageProvider} provides messages for a named value.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
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
