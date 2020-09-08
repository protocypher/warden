package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueMessagesTest {
    @Test
    @DisplayName("Given value=null, calling getMessagePrefix() returns \"Rejecting 'null'\"")
    public void given_value_is_null_calling_getMessagePrefix_returns_String() {
        ValueMessages messages = new ValueMessages(null);
        assertEquals("Rejecting 'null'", messages.getMessagePrefix());
    }

    @Test
    @DisplayName("Given value=3, calling getMessagePrefix() returns \"Rejecting '3'\"")
    public void given_value_is_3_calling_getMessagePrefix_returns_String() {
        ValueMessages messages = new ValueMessages(3);
        assertEquals("Rejecting '3'", messages.getMessagePrefix());
    }

    @Test
    @DisplayName("Given value=\"A\", calling getMessagePrefix() returns \"Rejecting 'A'\"")
    public void given_value_is_A_calling_getMessagePrefix_returns_String() {
        ValueMessages messages = new ValueMessages("A");
        assertEquals("Rejecting 'A'", messages.getMessagePrefix());
    }
}
