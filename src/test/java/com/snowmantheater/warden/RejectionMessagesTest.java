package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RejectionMessagesTest {
    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                          create()

    @Test
    @DisplayName("Calling of(null).create() returns \"Rejecting 'null'.\"")
    public void calling_of_w_null_then_create_returns_String() {
        RejectionMessages messages = RejectionMessages.of(null);
        assertEquals("Rejecting 'null'.", messages.create());
    }

    @Test
    @DisplayName("Calling of(\"a\", null).create() returns \"Rejecting a='null'.\"")
    public void calling_of_w_a_and_null_then_create_returns_String() {
        RejectionMessages messages = RejectionMessages.of("a", null);
        assertEquals("Rejecting a='null'.", messages.create());
    }

    @Test
    @DisplayName("Calling of(1).create() returns \"Rejecting '1'.\"")
    public void calling_of_w_1_then_create_returns_String() {
        RejectionMessages messages = RejectionMessages.of(1);
        assertEquals("Rejecting '1'.", messages.create());
    }

    @Test
    @DisplayName("Calling of(\"a\", 1).create() returns \"Rejecting a='1'.\"")
    public void calling_of_w_a_and_1_then_create_returns_String() {
        RejectionMessages messages = RejectionMessages.of("a", 1);
        assertEquals("Rejecting a='1'.", messages.create());
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                      createWith()

    @Test
    @DisplayName("Calling of(1).createWith(null) throws NPE")
    public void calling_of_w_1_then_createWith_w_null_throws_NPE() {
        RejectionMessages messages = RejectionMessages.of(1);
        assertThrows(
            NullPointerException.class,
            () -> messages.createWith(null)
        );
    }

    @Test
    @DisplayName("Calling of(\"a\", 1).createWith(null) throws NPE")
    public void calling_of_w_a_and_1_then_createWith_w_null_throws_NPE() {
        RejectionMessages messages = RejectionMessages.of("a", 1);
        assertThrows(
            NullPointerException.class,
            () -> messages.createWith(null)
        );
    }

    @Test
    @DisplayName("Calling of(1).createWith(\"reason\") returns \"Rejecting '1': reason\"")
    public void calling_of_w_1_then_createWith_w_String_returns_String() {
        RejectionMessages messages = RejectionMessages.of(1);
        assertEquals("Rejecting '1': reason", messages.createWith("reason"));
    }

    @Test
    @DisplayName("Calling of(\"a\", 1).createWith(\"reason\") returns \"Rejecting a='1': reason\"")
    public void calling_of_w_a_and_1_then_createWith_w_String_returns_String() {
        RejectionMessages messages = RejectionMessages.of("a", 1);
        assertEquals("Rejecting a='1': reason", messages.createWith("reason"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                       createFor()

    @Test
    @DisplayName("Calling of(1).createFor(null) throws NPE")
    public void calling_of_w_1_then_createFor_w_null_throws_NPE() {
        RejectionMessages messages = RejectionMessages.of(1);
        assertThrows(
            NullPointerException.class,
            () -> messages.createFor(null)
        );
    }

    @Test
    @DisplayName("Calling of(\"a\", 1).createFor(null) throws NPE")
    public void calling_of_w_a_and_1_then_createFor_w_null_throws_NPE() {
        RejectionMessages messages = RejectionMessages.of("a", 1);
        assertThrows(
            NullPointerException.class,
            () -> messages.createFor(null)
        );
    }

    @Test
    @DisplayName("Calling of(1).createFor(Exception(\"message\")) returns \"Rejecting '1': message\"")
    public void calling_of_w_1_then_createFor_w_Exception_returns_String() {
        RejectionMessages messages = RejectionMessages.of(1);
        assertEquals("Rejecting '1': message", messages.createFor(new Exception("message")));
    }

    @Test
    @DisplayName("Calling of(\"a\", 1).createWith(Exception(\"message\")) returns \"Rejecting a='1': message\"")
    public void calling_of_w_a_and_1_then_createFor_w_Exception_returns_String() {
        RejectionMessages messages = RejectionMessages.of("a", 1);
        assertEquals("Rejecting a='1': message", messages.createFor(new Exception("message")));
    }
}