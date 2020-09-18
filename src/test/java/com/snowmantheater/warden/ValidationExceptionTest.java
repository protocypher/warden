package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationExceptionTest {
    @Test
    @DisplayName("Calling new(null, String).getValue() returns null")
    public void calling_new_w_null_and_String_then_getValue_returns_null() {
        ValidationException exception = new ValidationException(null, "Rejected");
        assertNull(exception.getValue());
    }

    @Test
    @DisplayName("Calling new(true, String).getValue() returns true")
    public void calling_new_w_true_and_String_then_getValue_returns_true() {
        ValidationException exception = new ValidationException(true, "Rejected");
        assertTrue(exception.getValue() instanceof Boolean);
        assertTrue((Boolean)exception.getValue());
    }

    @Test
    @DisplayName("Calling new(1, String).getValue() returns 1")
    public void calling_new_w_1_and_String_then_getValue_returns_1() {
        ValidationException exception = new ValidationException(1, "Rejected");
        assertTrue(exception.getValue() instanceof Integer);
        assertEquals(1, (int)(Integer)exception.getValue());
    }

    @Test
    @DisplayName("Calling new(\"A\", String).getValue() returns \"A\"")
    public void calling_new_w_A_and_String_then_getValue_returns_A() {
        ValidationException exception = new ValidationException("A", "Rejected");
        assertTrue(exception.getValue() instanceof String);
        assertEquals("A", exception.getValue());
    }
}