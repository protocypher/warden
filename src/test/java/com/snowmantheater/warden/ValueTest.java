package com.snowmantheater.warden;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueTest {

    @Test
    void test_of_X() {
        Value value;

        value = Value.of(null);
        assertNotNull(value);
        assertTrue(value.isValue());
        assertFalse(value.isVariable());
        assertFalse(value.isField());

        value = Value.of("A");
        assertNotNull(value);
        assertTrue(value.isValue());
        assertFalse(value.isVariable());
        assertFalse(value.isField());

        value = Value.of(1);
        assertNotNull(value);
        assertTrue(value.isValue());
        assertFalse(value.isVariable());
        assertFalse(value.isField());
    }

    @Test
    void test_of_X_X() {
        Value value;
        String name = "name";

        assertThrows(NullPointerException.class, () -> Value.of(null, null));

        value = Value.of(name, null);
        assertNotNull(value);
        assertTrue(value.isValue() && value.isVariable());
        assertFalse(value.isField());

        value = Value.of(name, "A");
        assertNotNull(value);
        assertTrue(value.isValue() && value.isVariable());
        assertFalse(value.isField());

        value = Value.of(name, 1);
        assertNotNull(value);
        assertTrue(value.isValue() && value.isVariable());
        assertFalse(value.isField());
    }

    @Test
    void test_of_X_X_X() {
        Value value;
        String name = "name";
        Object parent = new Object();

        assertThrows(NullPointerException.class, () -> Value.of(null, name, null));
        assertThrows(NullPointerException.class, () -> Value.of(parent, null, null));

        value = Value.of(parent, name, null);
        assertNotNull(value);
        assertTrue(value.isValue() && value.isVariable() && value.isField());

        value = Value.of(parent, name, "A");
        assertNotNull(value);
        assertTrue(value.isValue() && value.isVariable() && value.isField());

        value = Value.of(parent, name, 1);
        assertNotNull(value);
        assertTrue(value.isValue() && value.isVariable() && value.isField());
    }

    @Test
    void test_toString_for_Value() {
        Value value;

        value = Value.of(null);
        assertEquals("\"null\"", value.toString());

        value = Value.of("A");
        assertEquals("\"A\"", value.toString());

        value = Value.of(1);
        assertEquals("\"1\"", value.toString());
    }

    @Test
    void test_toString_for_Variable() {
        Value value;
        String name = "name";

        value = Value.of(name, null);
        assertEquals("name=\"null\"", value.toString());

        value = Value.of(name, "A");
        assertEquals("name=\"A\"", value.toString());

        value = Value.of(name, 1);
        assertEquals("name=\"1\"", value.toString());
    }

    @Test
    void test_toString_for_Field() {
        Value value;
        String name = "name";
        Object parent = new Object();

        value = Value.of(parent, name, null);
        assertEquals("Object.name=\"null\"", value.toString());

        value = Value.of(parent, name, "A");
        assertEquals("Object.name=\"A\"", value.toString());

        value = Value.of(parent, name, 1);
        assertEquals("Object.name=\"1\"", value.toString());
    }
}