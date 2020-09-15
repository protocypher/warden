package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RejectionExceptionTest {
    @Test
    @DisplayName("Calling new(null, String).getValue() returns null")
    public void calling_new_w_null_and_String_then_getValue_returns_null() {
        RejectionException exception = new RejectionException(null, "Rejected");
        assertNull(exception.getValue());
    }

    @Test
    @DisplayName("Calling new(true, String).getValue() returns true")
    public void calling_new_w_true_and_String_then_getValue_returns_true() {
        RejectionException exception = new RejectionException(true, "Rejected");
        assertTrue(exception.getValue() instanceof Boolean);
        assertTrue((Boolean)exception.getValue());
    }

    @Test
    @DisplayName("Calling new(1, String).getValue() returns 1")
    public void calling_new_w_1_and_String_then_getValue_returns_1() {
        RejectionException exception = new RejectionException(1, "Rejected");
        assertTrue(exception.getValue() instanceof Integer);
        assertEquals(1, (int)(Integer)exception.getValue());
    }

    @Test
    @DisplayName("Calling new(\"A\", String).getValue() returns \"A\"")
    public void calling_new_w_A_and_String_then_getValue_returns_A() {
        RejectionException exception = new RejectionException("A", "Rejected");
        assertTrue(exception.getValue() instanceof String);
        assertEquals("A", exception.getValue());
    }
}