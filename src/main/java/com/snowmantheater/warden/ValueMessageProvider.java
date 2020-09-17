package com.snowmantheater.warden;

/**
 * A {@link ValueMessageProvider} provides messages for an unnamed value.
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
