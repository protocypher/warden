package com.snowmantheater.warden;

/**
 * A {@link ValueMessageProvider} provides messages for an unnamed value.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
class ValueMessageProvider extends AbstractMessageProvider {
    /**
     * Creates a new {@link ValueMessageProvider} for {@code value}.
     *
     * @param value The given value
     */
    ValueMessageProvider(Object value) {
        super("'" + value + "'");
    }
}
