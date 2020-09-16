package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueMessageProviderTest {
    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                             getRejectingMessage()

    @Test
    @DisplayName("Given value=null Calling getRejectingMessage() returns \"Rejecting 'null'.\"")
    public void given_value_is_null_calling_getRejectingMessage_returns_String() {
        MessageProvider messages = new ValueMessageProvider(null);
        assertEquals("Rejecting 'null'.", messages.getRejectingMessage());
    }

    @Test
    @DisplayName("Given value=1 Calling getRejectingMessage() returns \"Rejecting '1'.\"")
    public void given_value_is_1_calling_getRejectingMessage_returns_String() {
        MessageProvider messages = new ValueMessageProvider(1);
        assertEquals("Rejecting '1'.", messages.getRejectingMessage());
    }

    @Test
    @DisplayName("Given value=\"A\" Calling getRejectingMessage() returns \"Rejecting 'A'.\"")
    public void given_value_is_A_calling_getRejectingMessage_returns_String() {
        MessageProvider messages = new ValueMessageProvider("A");
        assertEquals("Rejecting 'A'.", messages.getRejectingMessage());
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                         getRejectingMessage(null)

    @Test
    @DisplayName("Given value=null Calling getRejectingMessage(null) throws NPE")
    public void given_value_is_null_calling_getRejectingMessage_w_null_throws_NPE() {
        MessageProvider messages = new ValueMessageProvider(null);
        assertThrows(NullPointerException.class, () -> messages.getRejectingMessage(null));
    }

    @Test
    @DisplayName("Given value=1 Calling getRejectingMessage(null) throws NPE")
    public void given_value_is_1_calling_RejectingMessage_w_null_throws_NPE() {
        MessageProvider messages = new ValueMessageProvider(1);
        assertThrows(NullPointerException.class, () -> messages.getRejectingMessage(null));
    }

    @Test
    @DisplayName("Given value=\"A\" Calling getRejectingMessage(null) throws NPE")
    public void given_value_is_A_calling_RejectingMessage_w_null_throws_NPE() {
        MessageProvider messages = new ValueMessageProvider("A");
        assertThrows(NullPointerException.class, () -> messages.getRejectingMessage(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                     getRejectingMessage("reason")

    @Test
    @DisplayName("Given value=null Calling getRejectingMessage(\"reason\") returns \"Rejecting 'null': reason\"")
    public void given_value_is_null_calling_getRejectingMessage_w_String_returns_String() {
        MessageProvider messages = new ValueMessageProvider(null);
        assertEquals("Rejecting 'null': reason", messages.getRejectingMessage("reason"));
    }

    @Test
    @DisplayName("Given value=1 Calling getRejectingMessage(\"reason\") returns \"Rejecting '1': reason\"")
    public void given_value_is_1_calling_RejectingMessage_w_String_returns_String() {
        MessageProvider messages = new ValueMessageProvider(1);
        assertEquals("Rejecting '1': reason", messages.getRejectingMessage("reason"));
    }

    @Test
    @DisplayName("Given value=\"A\" Calling getRejectingMessage(\"reason\") returns \"Rejecting 'A': reason\"")
    public void given_value_is_A_calling_RejectingMessage_w_String_returns_String() {
        MessageProvider messages = new ValueMessageProvider("A");
        assertEquals("Rejecting 'A': reason", messages.getRejectingMessage("reason"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                             getAcceptingMessage()

    @Test
    @DisplayName("Given value=null Calling getAcceptingMessage() returns \"Accepting 'null'.\"")
    public void given_value_is_null_calling_getAcceptingMessage_returns_String() {
        MessageProvider messages = new ValueMessageProvider(null);
        assertEquals("Accepting 'null'.", messages.getAcceptingMessage());
    }

    @Test
    @DisplayName("Given value=1 Calling getAcceptingMessage() returns \"Accepting '1'.\"")
    public void given_value_is_1_calling_AcceptingMessage_returns_String() {
        MessageProvider messages = new ValueMessageProvider(1);
        assertEquals("Accepting '1'.", messages.getAcceptingMessage());
    }

    @Test
    @DisplayName("Given value=\"A\" Calling getAcceptingMessage() returns \"Accepting 'A'.\"")
    public void given_value_is_A_calling_AcceptingMessage_returns_String() {
        MessageProvider messages = new ValueMessageProvider("A");
        assertEquals("Accepting 'A'.", messages.getAcceptingMessage());
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                         getAcceptingMessage(null)

    @Test
    @DisplayName("Given value=null Calling getAcceptingMessage(null) throws NPE")
    public void given_value_is_null_calling_getAcceptingMessage_w_null_throws_NPE() {
        MessageProvider messages = new ValueMessageProvider(null);
        assertThrows(NullPointerException.class, () -> messages.getAcceptingMessage(null));
    }

    @Test
    @DisplayName("Given value=1 Calling getAcceptingMessage(null) throws NPE")
    public void given_value_is_1_calling_AcceptingMessage_w_null_throws_NPE() {
        MessageProvider messages = new ValueMessageProvider(1);
        assertThrows(NullPointerException.class, () -> messages.getAcceptingMessage(null));
    }

    @Test
    @DisplayName("Given value=\"A\" Calling getAcceptingMessage(null) throws NPE")
    public void given_value_is_A_calling_AcceptingMessage_w_null_throws_NPE() {
        MessageProvider messages = new ValueMessageProvider("A");
        assertThrows(NullPointerException.class, () -> messages.getAcceptingMessage(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                     getAcceptingMessage("reason")

    @Test
    @DisplayName("Given value=null Calling getAcceptingMessage(\"reason\") returns \"Accepting 'null': reason\"")
    public void given_value_is_null_calling_getAcceptingMessage_w_String_returns_String() {
        MessageProvider messages = new ValueMessageProvider(null);
        assertEquals("Accepting 'null': reason", messages.getAcceptingMessage("reason"));
    }

    @Test
    @DisplayName("Given value=1 Calling getAcceptingMessage(\"reason\") returns \"Accepting '1': reason\"")
    public void given_value_is_1_calling_AcceptingMessage_w_String_returns_String() {
        MessageProvider messages = new ValueMessageProvider(1);
        assertEquals("Accepting '1': reason", messages.getAcceptingMessage("reason"));
    }

    @Test
    @DisplayName("Given value=\"A\" Calling getAcceptingMessage(\"reason\") returns \"Accepting 'A': reason\"")
    public void given_value_is_A_calling_AcceptingMessage_w_String_returns_String() {
        MessageProvider messages = new ValueMessageProvider("A");
        assertEquals("Accepting 'A': reason", messages.getAcceptingMessage("reason"));
    }
}