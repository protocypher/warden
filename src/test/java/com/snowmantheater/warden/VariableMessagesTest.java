package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VariableMessagesTest {
    @Test
    @DisplayName("Given name=null and value=null, calling new throws NullPointerException")
    public void given_name_is_null_and_value_is_null_calling_new_throws_NPE() {
        assertThrows(
            NullPointerException.class,
            () -> new VariableMessages(null, null)
        );
    }

    @Test
    @DisplayName("Given name=\"n\" and value=null, calling getMessagePrefix() returns \"Rejecting n='null'\"")
    public void given_name_is_n_and_value_is_null_calling_getMessagePrefix_returns_String() {
        VariableMessages messages = new VariableMessages("n", null);
        assertEquals("Rejecting n='null'", messages.getMessagePrefix());
    }

    @Test
    @DisplayName("Given name=\"n\" and value=3, calling getMessagePrefix() returns \"Rejecting n='3'\"")
    public void given_name_is_n_and_value_is_3_calling_getMessagePrefix_returns_String() {
        VariableMessages messages = new VariableMessages("n", 3);
        assertEquals("Rejecting n='3'", messages.getMessagePrefix());
    }

    @Test
    @DisplayName("Given name=\"n\" and value=\"A\", calling getMessagePrefix() returns \"Rejecting n='A'\"")
    public void given_name_is_n_and_value_is_A_calling_getMessagePrefix_returns_String() {
        VariableMessages messages = new VariableMessages("n", "A");
        assertEquals("Rejecting n='A'", messages.getMessagePrefix());
    }
}
