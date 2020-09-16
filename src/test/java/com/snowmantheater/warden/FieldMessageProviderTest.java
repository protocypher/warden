package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FieldMessageProviderTest {
    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                             new()

    @Test
    @DisplayName("Calling new(null, null) throws NPE")
    public void calling_new_w_null_null_throws_NPE() {
        assertThrows(NullPointerException.class, () -> new FieldMessageProvider(null, null));
    }

    @Test
    @DisplayName("Calling new(null, 1) throws NPE")
    public void calling_new_w_null_1_throws_NPE() {
        assertThrows(NullPointerException.class, () -> new FieldMessageProvider(null, 1));
    }

    @Test
    @DisplayName("Calling new(null, \"A\") throws NPE")
    public void calling_new_w_null_A_throws_NPE() {
        assertThrows(NullPointerException.class, () -> new FieldMessageProvider(null, "A"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                             getRejectingMessage()

    @Test
    @DisplayName("Given name=\"Name\", value=null Calling getRejectingMessage() returns \"Rejecting 'null'.\"")
    public void given_name_is_Name_and_value_is_null_calling_getRejectingMessage_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", null);
        assertEquals("Rejecting Name='null'.", messages.getRejectingMessage());
    }

    @Test
    @DisplayName("Given name=\"Name\", value=1 Calling getRejectingMessage() returns \"Rejecting '1'.\"")
    public void given_name_is_Name_and_value_is_1_calling_getRejectingMessage_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", 1);
        assertEquals("Rejecting Name='1'.", messages.getRejectingMessage());
    }

    @Test
    @DisplayName("Given name=\"Name\", value=\"A\" Calling getRejectingMessage() returns \"Rejecting 'A'.\"")
    public void given_name_is_Name_and_value_is_A_calling_getRejectingMessage_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", "A");
        assertEquals("Rejecting Name='A'.", messages.getRejectingMessage());
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                         getRejectingMessage(null)

    @Test
    @DisplayName("Given name=\"Name\", value=null Calling getRejectingMessage(null) throws NPE")
    public void given_name_is_Name_and_value_is_null_calling_getRejectingMessage_w_null_throws_NPE() {
        MessageProvider messages = new FieldMessageProvider("Name", null);
        assertThrows(NullPointerException.class, () -> messages.getRejectingMessage(null));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=1 Calling getRejectingMessage(null) throws NPE")
    public void given_name_is_Name_and_value_is_1_calling_RejectingMessage_w_null_throws_NPE() {
        MessageProvider messages = new FieldMessageProvider("Name", 1);
        assertThrows(NullPointerException.class, () -> messages.getRejectingMessage(null));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=\"A\" Calling getRejectingMessage(null) throws NPE")
    public void given_name_is_Name_and_value_is_A_calling_RejectingMessage_w_null_throws_NPE() {
        MessageProvider messages = new FieldMessageProvider("Name", "A");
        assertThrows(NullPointerException.class, () -> messages.getRejectingMessage(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                     getRejectingMessage("reason")

    @Test
    @DisplayName("Given name=\"Name\", value=null Calling getRejectingMessage(\"reason\") returns \"Rejecting 'null': reason\"")
    public void given_name_is_Name_and_value_is_null_calling_getRejectingMessage_w_String_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", null);
        assertEquals("Rejecting Name='null': reason", messages.getRejectingMessage("reason"));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=1 Calling getRejectingMessage(\"reason\") returns \"Rejecting '1': reason\"")
    public void given_name_is_Name_and_value_is_1_calling_RejectingMessage_w_String_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", 1);
        assertEquals("Rejecting Name='1': reason", messages.getRejectingMessage("reason"));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=\"A\" Calling getRejectingMessage(\"reason\") returns \"Rejecting 'A': reason\"")
    public void given_name_is_Name_and_value_is_A_calling_RejectingMessage_w_String_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", "A");
        assertEquals("Rejecting Name='A': reason", messages.getRejectingMessage("reason"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                             getAcceptingMessage()

    @Test
    @DisplayName("Given name=\"Name\", value=null Calling getAcceptingMessage() returns \"Accepting 'null'.\"")
    public void given_name_is_Name_and_value_is_null_calling_getAcceptingMessage_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", null);
        assertEquals("Accepting Name='null'.", messages.getAcceptingMessage());
    }

    @Test
    @DisplayName("Given name=\"Name\", value=1 Calling getAcceptingMessage() returns \"Accepting '1'.\"")
    public void given_name_is_Name_and_value_is_1_calling_AcceptingMessage_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", 1);
        assertEquals("Accepting Name='1'.", messages.getAcceptingMessage());
    }

    @Test
    @DisplayName("Given name=\"Name\", value=\"A\" Calling getAcceptingMessage() returns \"Accepting 'A'.\"")
    public void given_name_is_Name_and_value_is_A_calling_AcceptingMessage_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", "A");
        assertEquals("Accepting Name='A'.", messages.getAcceptingMessage());
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                         getAcceptingMessage(null)

    @Test
    @DisplayName("Given name=\"Name\", value=null Calling getAcceptingMessage(null) throws NPE")
    public void given_name_is_Name_and_value_is_null_calling_getAcceptingMessage_w_null_throws_NPE() {
        MessageProvider messages = new FieldMessageProvider("Name", null);
        assertThrows(NullPointerException.class, () -> messages.getAcceptingMessage(null));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=1 Calling getAcceptingMessage(null) throws NPE")
    public void given_name_is_Name_and_value_is_1_calling_AcceptingMessage_w_null_throws_NPE() {
        MessageProvider messages = new FieldMessageProvider("Name", 1);
        assertThrows(NullPointerException.class, () -> messages.getAcceptingMessage(null));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=\"A\" Calling getAcceptingMessage(null) throws NPE")
    public void given_name_is_Name_and_value_is_A_calling_AcceptingMessage_w_null_throws_NPE() {
        MessageProvider messages = new FieldMessageProvider("Name", "A");
        assertThrows(NullPointerException.class, () -> messages.getAcceptingMessage(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                     getAcceptingMessage("reason")

    @Test
    @DisplayName("Given name=\"Name\", value=null Calling getAcceptingMessage(\"reason\") returns \"Accepting 'null': reason\"")
    public void given_name_is_Name_and_value_is_null_calling_getAcceptingMessage_w_String_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", null);
        assertEquals("Accepting Name='null': reason", messages.getAcceptingMessage("reason"));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=1 Calling getAcceptingMessage(\"reason\") returns \"Accepting '1': reason\"")
    public void given_name_is_Name_and_value_is_1_calling_AcceptingMessage_w_String_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", 1);
        assertEquals("Accepting Name='1': reason", messages.getAcceptingMessage("reason"));
    }

    @Test
    @DisplayName("Given name=\"Name\", value=\"A\" Calling getAcceptingMessage(\"reason\") returns \"Accepting 'A': reason\"")
    public void given_name_is_Name_and_value_is_A_calling_AcceptingMessage_w_String_returns_String() {
        MessageProvider messages = new FieldMessageProvider("Name", "A");
        assertEquals("Accepting Name='A': reason", messages.getAcceptingMessage("reason"));
    }
}