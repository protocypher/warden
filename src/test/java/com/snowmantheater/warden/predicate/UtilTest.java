package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {
    @Test
    @DisplayName("Calling getSizeOf(primitive) returns empty")
    public void calling_getSizeOf_w_primitive_returns_empty() {
        assertFalse(Util.getSizeOf(BOOL_FALSE).isPresent());
        assertFalse(Util.getSizeOf(BOOL_TRUE).isPresent());

        assertFalse(Util.getSizeOf(BYTE_NEG3).isPresent());
        assertFalse(Util.getSizeOf(BYTE_ZERO).isPresent());
        assertFalse(Util.getSizeOf(BYTE_POS3).isPresent());

        assertFalse(Util.getSizeOf(CHAR_0).isPresent());
        assertFalse(Util.getSizeOf(CHAR_A).isPresent());
        assertFalse(Util.getSizeOf(CHAR_M).isPresent());
        assertFalse(Util.getSizeOf(CHAR_Z).isPresent());

        assertFalse(Util.getSizeOf(DOUBLE_NEG3).isPresent());
        assertFalse(Util.getSizeOf(DOUBLE_ZERO).isPresent());
        assertFalse(Util.getSizeOf(DOUBLE_POS3).isPresent());

        assertFalse(Util.getSizeOf(FLOAT_NEG3).isPresent());
        assertFalse(Util.getSizeOf(FLOAT_ZERO).isPresent());
        assertFalse(Util.getSizeOf(FLOAT_POS3).isPresent());

        assertFalse(Util.getSizeOf(INT_NEG3).isPresent());
        assertFalse(Util.getSizeOf(INT_ZERO).isPresent());
        assertFalse(Util.getSizeOf(INT_POS3).isPresent());

        assertFalse(Util.getSizeOf(LONG_NEG3).isPresent());
        assertFalse(Util.getSizeOf(LONG_ZERO).isPresent());
        assertFalse(Util.getSizeOf(LONG_POS3).isPresent());

        assertFalse(Util.getSizeOf(SHORT_NEG3).isPresent());
        assertFalse(Util.getSizeOf(SHORT_ZERO).isPresent());
        assertFalse(Util.getSizeOf(SHORT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(null) returns empty")
    public void calling_getSizeOf_w_null_returns_empty() {
        assertFalse(Util.getSizeOf(null).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(instance) returns empty")
    public void calling_getSizeOf_w_instance_returns_empty() {
        assertFalse(Util.getSizeOf(NUMBER_NEG3).isPresent());
        assertFalse(Util.getSizeOf(NUMBER_ZERO).isPresent());
        assertFalse(Util.getSizeOf(NUMBER_POS3).isPresent());

        assertFalse(Util.getSizeOf(OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(String) returns String::length")
    public void calling_getSizeOf_w_String_returns_String$length() {
        assertTrue(Util.getSizeOf(STRING_EMPTY).filter(s -> s == STRING_EMPTY.length()).isPresent());
        assertTrue(Util.getSizeOf(STRING_ABC).filter(s -> s == STRING_ABC.length()).isPresent());
        assertTrue(Util.getSizeOf(STRING_XYZ).filter(s -> s == STRING_XYZ.length()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Collection) returns Collection::size")
    public void calling_getSizeOf_w_Collection_returns_Collection$size() {
        assertTrue(Util.getSizeOf(LIST_EMPTY).filter(s -> s == LIST_EMPTY.size()).isPresent());
        assertTrue(Util.getSizeOf(LIST_VALUE).filter(s -> s == LIST_VALUE.size()).isPresent());

        assertTrue(Util.getSizeOf(MAP_EMPTY).filter(s -> s == MAP_EMPTY.size()).isPresent());
        assertTrue(Util.getSizeOf(MAP_VALUE).filter(s -> s == MAP_VALUE.size()).isPresent());

        assertTrue(Util.getSizeOf(SET_EMPTY).filter(s -> s == SET_EMPTY.size()).isPresent());
        assertTrue(Util.getSizeOf(SET_VALUE).filter(s -> s == SET_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(array) returns array.length")
    public void calling_getSizeOf_w_array_returns_array$length() {
        assertTrue(Util.getSizeOf(ARRAY_OBJECT_EMPTY).filter(s -> s == ARRAY_OBJECT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_OBJECT_VALUE).filter(s -> s == ARRAY_OBJECT_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_BOOL_EMPTY).filter(s -> s == ARRAY_BOOL_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_BOOL_VALUE).filter(s -> s == ARRAY_BOOL_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_BYTE_EMPTY).filter(s -> s == ARRAY_BYTE_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_BYTE_VALUE).filter(s -> s == ARRAY_BYTE_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_CHAR_EMPTY).filter(s -> s == ARRAY_CHAR_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_CHAR_VALUE).filter(s -> s == ARRAY_CHAR_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_DOUBLE_EMPTY).filter(s -> s == ARRAY_DOUBLE_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_DOUBLE_VALUE).filter(s -> s == ARRAY_DOUBLE_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_FLOAT_EMPTY).filter(s -> s == ARRAY_FLOAT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_FLOAT_VALUE).filter(s -> s == ARRAY_FLOAT_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_INT_EMPTY).filter(s -> s == ARRAY_INT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_INT_VALUE).filter(s -> s == ARRAY_INT_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_LONG_EMPTY).filter(s -> s == ARRAY_LONG_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_LONG_VALUE).filter(s -> s == ARRAY_LONG_VALUE.length).isPresent());

        assertTrue(Util.getSizeOf(ARRAY_SHORT_EMPTY).filter(s -> s == ARRAY_SHORT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_SHORT_VALUE).filter(s -> s == ARRAY_SHORT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(primitive) returns Comparable")
    public void calling_getComparableOf_w_primitive_returns_Comparable() {
        assertTrue(Util.getComparableOf(BOOL_TRUE).isPresent());
        assertTrue(Util.getComparableOf(BOOL_FALSE).isPresent());

        assertTrue(Util.getComparableOf(BYTE_NEG3).isPresent());
        assertTrue(Util.getComparableOf(BYTE_ZERO).isPresent());
        assertTrue(Util.getComparableOf(BYTE_POS3).isPresent());

        assertTrue(Util.getComparableOf(CHAR_0).isPresent());
        assertTrue(Util.getComparableOf(CHAR_A).isPresent());
        assertTrue(Util.getComparableOf(CHAR_M).isPresent());
        assertTrue(Util.getComparableOf(CHAR_Z).isPresent());

        assertTrue(Util.getComparableOf(DOUBLE_NEG3).isPresent());
        assertTrue(Util.getComparableOf(DOUBLE_ZERO).isPresent());
        assertTrue(Util.getComparableOf(DOUBLE_POS3).isPresent());

        assertTrue(Util.getComparableOf(FLOAT_NEG3).isPresent());
        assertTrue(Util.getComparableOf(FLOAT_ZERO).isPresent());
        assertTrue(Util.getComparableOf(FLOAT_POS3).isPresent());

        assertTrue(Util.getComparableOf(INT_NEG3).isPresent());
        assertTrue(Util.getComparableOf(INT_ZERO).isPresent());
        assertTrue(Util.getComparableOf(INT_POS3).isPresent());

        assertTrue(Util.getComparableOf(LONG_NEG3).isPresent());
        assertTrue(Util.getComparableOf(LONG_ZERO).isPresent());
        assertTrue(Util.getComparableOf(LONG_POS3).isPresent());

        assertTrue(Util.getComparableOf(SHORT_NEG3).isPresent());
        assertTrue(Util.getComparableOf(SHORT_ZERO).isPresent());
        assertTrue(Util.getComparableOf(SHORT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(null) returns empty")
    public void calling_getComparableOf_w_null_returns_empty() {
        assertFalse(Util.getComparableOf(null).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(instance) returns empty")
    public void calling_getComparableOf_w_instance_returns_empty() {
        assertFalse(Util.getComparableOf(OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(instance of Comparable) returns Comparable")
    public void calling_getComparableOf_w_instance_of_Comparable_returns_Comparable() {
        assertTrue(Util.getComparableOf(NUMBER_NEG3).isPresent());
        assertTrue(Util.getComparableOf(NUMBER_ZERO).isPresent());
        assertTrue(Util.getComparableOf(NUMBER_POS3).isPresent());

        assertTrue(Util.getComparableOf(STRING_EMPTY).isPresent());
        assertTrue(Util.getComparableOf(STRING_ABC).isPresent());
        assertTrue(Util.getComparableOf(STRING_XYZ).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(String) returns Comparable")
    public void Calling_getComparableOf_String_returns_Comparable() {
    }

    @Test
    @DisplayName("Calling getComparableOf(Collection) returns empty")
    public void calling_getComparableOf_w_Collection_returns_empty() {
        assertFalse(Util.getComparableOf(LIST_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(LIST_VALUE).isPresent());

        assertFalse(Util.getComparableOf(MAP_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(MAP_VALUE).isPresent());

        assertFalse(Util.getComparableOf(SET_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(SET_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(array) returns empty")
    public void calling_getComparableOf_w_array_returns_empty() {
        assertFalse(Util.getComparableOf(ARRAY_OBJECT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_OBJECT_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_BOOL_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_BOOL_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_BYTE_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_BYTE_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_CHAR_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_CHAR_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_DOUBLE_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_DOUBLE_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_FLOAT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_FLOAT_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_INT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_INT_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_LONG_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_LONG_VALUE).isPresent());

        assertFalse(Util.getComparableOf(ARRAY_SHORT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_SHORT_VALUE).isPresent());
    }
}
