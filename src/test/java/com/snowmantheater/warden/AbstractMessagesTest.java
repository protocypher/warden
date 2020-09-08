package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMessagesTest {
    @Test
    @DisplayName("Calling getMessage() returns \"PREFIX\"")
    public void calling_getMessage_returns_String() {
        Messages messages = new TestMessages();
        assertEquals("PREFIX", messages.getMessage());
    }

    @Test
    @DisplayName("Calling getMessage((String)null) returns \"PREFIX: null\"")
    public void calling_getMessage_with_String_null_returns_String() {
        Messages messages = new TestMessages();
        assertEquals("PREFIX: null", messages.getMessage((String)null));
    }

    @Test
    @DisplayName("Calling getMessage(\"test\") returns \"PREFIX: test\"")
    public void calling_getMessage_with_test_returns_String() {
        Messages messages = new TestMessages();
        assertEquals("PREFIX: test", messages.getMessage("test"));
    }

    @Test
    @DisplayName("Calling getMessage((Throwable)null) throws NullPointerException")
    public void calling_getMessage_with_Throwable_null_throws_NPE() {
        Messages messages = new TestMessages();
        assertThrows(NullPointerException.class, () -> messages.getMessage((Throwable)null));
    }

    @Test
    @DisplayName("Calling getMessage(Ex{message=null}) returns \"PREFIX: null\"")
    public void calling_getMessage_with_ExM_null_returns_String() {
        Messages messages = new TestMessages();
        Exception exception = new Exception();
        assertEquals("PREFIX: null", messages.getMessage(exception));
    }

    @Test
    @DisplayName("Calling getMessage(Ex{message=\"test\"}) returns \"PREFIX: test\"")
    public void calling_getMessage_with_ExM_test_returns_String() {
        Messages messages = new TestMessages();
        Exception exception = new Exception("test");
        assertEquals("PREFIX: test", messages.getMessage(exception));
    }
}
