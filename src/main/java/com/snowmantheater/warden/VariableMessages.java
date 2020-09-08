package com.snowmantheater.warden;

/**
 * This class provides messages about named values, or variables.
 */
public class VariableMessages extends AbstractMessages implements Messages {
    private final String name;
    private final Object value;

    /**
     * Instantiates a new {@code VariableMessages} to produce messages about
     * {@code value}.
     *
     * @param name The name of the variable
     * @param value The topic of the messages
     */
    VariableMessages(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessagePrefix() {
        return "Rejecting " + name + "='" + value + "'";
    }
}
