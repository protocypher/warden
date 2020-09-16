package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {
    @Test
    @DisplayName("Calling of(null) returns ValueMessageProvider")
    public void calling_of_w_null_returns_ValueMessageProvider() {
        MessageProvider messages = MessageProvider.of(null);
        assertEquals(messages.getClass(), ValueMessageProvider.class);
    }

    @Test
    @DisplayName("Calling of(1) returns ValueMessageProvider")
    public void calling_of_w_1_returns_ValueMessageProvider() {
        MessageProvider messages = MessageProvider.of(1);
        assertEquals(messages.getClass(), ValueMessageProvider.class);
    }

    @Test
    @DisplayName("Calling of(\"A\") returns ValueMessageProvider")
    public void calling_of_w_A_returns_ValueMessageProvider() {
        MessageProvider messages = MessageProvider.of("A");
        assertEquals(messages.getClass(), ValueMessageProvider.class);
    }

    @Test
    @DisplayName("Calling of(null, null) throws NPE")
    public void calling_of_w_null_and_null_throws_NPE() {
        assertThrows(NullPointerException.class, () -> MessageProvider.of(null, null));
    }

    @Test
    @DisplayName("Calling of(null, 1) throws NPE")
    public void calling_of_w_null_and_1_throws_NPE() {
        assertThrows(NullPointerException.class, () -> MessageProvider.of(null, 1));
    }

    @Test
    @DisplayName("Calling of(null, \"A\") throws NPE")
    public void calling_of_w_null_and_A_throws_NPE() {
        assertThrows(NullPointerException.class, () -> MessageProvider.of(null, "A"));
    }

    @Test
    @DisplayName("Calling of(\"name\", null) returns FieldMessageProvider")
    public void calling_of_w_name_and_null_returns_FieldMessageProvider() {
        MessageProvider messages = MessageProvider.of("name", null);
        assertEquals(messages.getClass(), FieldMessageProvider.class);
    }

    @Test
    @DisplayName("Calling of(\"name\", 1) returns FieldMessageProvider")
    public void calling_of_w_name_and_1_returns_FieldMessageProvider() {
        MessageProvider messages = MessageProvider.of("name", 1);
        assertEquals(messages.getClass(), FieldMessageProvider.class);
    }

    @Test
    @DisplayName("Calling of(\"name\", \"A\") returns FieldMessageProvider")
    public void calling_of_w_name_and_A_returns_FieldMessageProvider() {
        MessageProvider messages = MessageProvider.of("name", "A");
        assertEquals(messages.getClass(), FieldMessageProvider.class);
    }
}