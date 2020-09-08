package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.snowmantheater.warden.predicate.Utils.*;
import static com.snowmantheater.warden.predicate.ValidationData.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    @DisplayName("Calling getSizeOf(boolean) returns EMPTY")
    public void Calling_getSizeOf_boolean_returns_EMPTY() {
        assertFalse(getSizeOf(BOOL_FALSE).isPresent());
        assertFalse(getSizeOf(BOOL_TRUE).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(byte) returns EMPTY")
    public void Calling_getSizeOf_byte_returns_EMPTY() {
        assertFalse(getSizeOf(BYTE_NEG3).isPresent());
        assertFalse(getSizeOf(BYTE_ZERO).isPresent());
        assertFalse(getSizeOf(BYTE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(char) returns EMPTY")
    public void Calling_getSizeOf_char_returns_EMPTY() {
        assertFalse(getSizeOf(CHAR_0).isPresent());
        assertFalse(getSizeOf(CHAR_A).isPresent());
        assertFalse(getSizeOf(CHAR_M).isPresent());
        assertFalse(getSizeOf(CHAR_Z).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(double) returns EMPTY")
    public void Calling_getSizeOf_double_returns_EMPTY() {
        assertFalse(getSizeOf(DOUBLE_NEG3).isPresent());
        assertFalse(getSizeOf(DOUBLE_ZERO).isPresent());
        assertFalse(getSizeOf(DOUBLE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(float) returns EMPTY")
    public void Calling_getSizeOf_float_returns_EMPTY() {
        assertFalse(getSizeOf(FLOAT_NEG3).isPresent());
        assertFalse(getSizeOf(FLOAT_ZERO).isPresent());
        assertFalse(getSizeOf(FLOAT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(int) returns EMPTY")
    public void Calling_getSizeOf_int_returns_EMPTY() {
        assertFalse(getSizeOf(INT_NEG3).isPresent());
        assertFalse(getSizeOf(INT_ZERO).isPresent());
        assertFalse(getSizeOf(INT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(long) returns EMPTY")
    public void Calling_getSizeOf_long_returns_EMPTY() {
        assertFalse(getSizeOf(LONG_NEG3).isPresent());
        assertFalse(getSizeOf(LONG_ZERO).isPresent());
        assertFalse(getSizeOf(LONG_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(short) returns EMPTY")
    public void Calling_getSizeOf_short_returns_EMPTY() {
        assertFalse(getSizeOf(SHORT_NEG3).isPresent());
        assertFalse(getSizeOf(SHORT_ZERO).isPresent());
        assertFalse(getSizeOf(SHORT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(null) returns EMPTY")
    public void Calling_getSizeOf_null_returns_EMPTY() {
        assertFalse(getSizeOf(NUMBER_NULL).isPresent());
        assertFalse(getSizeOf(OBJECT_NULL).isPresent());
        assertFalse(getSizeOf(STRING_NULL).isPresent());
        assertFalse(getSizeOf(LIST_NULL).isPresent());
        assertFalse(getSizeOf(MAP_NULL).isPresent());
        assertFalse(getSizeOf(SET_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_OBJECT_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_BOOL_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_BYTE_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_CHAR_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_DOUBLE_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_FLOAT_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_INT_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_LONG_NULL).isPresent());
        assertFalse(getSizeOf(ARRAY_SHORT_NULL).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Number) returns EMPTY")
    public void Calling_getSizeOf_Number_returns_EMPTY() {
        assertFalse(getSizeOf(NUMBER_NEG3).isPresent());
        assertFalse(getSizeOf(NUMBER_ZERO).isPresent());
        assertFalse(getSizeOf(NUMBER_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Object) returns EMPTY")
    public void Calling_getSizeOf_Object_returns_EMPTY() {
        assertFalse(getSizeOf(OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(String) returns <size>")
    public void Calling_getSizeOf_String_returns_SIZE() {
        assertTrue(getSizeOf(STRING_EMPTY).filter(s -> s == STRING_EMPTY.length()).isPresent());
        assertTrue(getSizeOf(STRING_ABC).filter(s -> s == STRING_ABC.length()).isPresent());
        assertTrue(getSizeOf(STRING_XYZ).filter(s -> s == STRING_XYZ.length()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(List) returns <size>")
    public void Calling_getSizeOf_List_returns_SIZE() {
        assertTrue(getSizeOf(LIST_EMPTY).filter(s -> s == LIST_EMPTY.size()).isPresent());
        assertTrue(getSizeOf(LIST_VALUE).filter(s -> s == LIST_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Map) returns <size>")
    public void Calling_getSizeOf_Map_returns_SIZE() {
        assertTrue(getSizeOf(MAP_EMPTY).filter(s -> s == MAP_EMPTY.size()).isPresent());
        assertTrue(getSizeOf(MAP_VALUE).filter(s -> s == MAP_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Set) returns <size>")
    public void Calling_getSizeOf_Set_returns_SIZE() {
        assertTrue(getSizeOf(SET_EMPTY).filter(s -> s == SET_EMPTY.size()).isPresent());
        assertTrue(getSizeOf(SET_VALUE).filter(s -> s == SET_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Object[]) returns <size>")
    public void Calling_getSizeOf_ObjectArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_OBJECT_EMPTY).filter(s -> s == ARRAY_OBJECT_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_OBJECT_VALUE).filter(s -> s == ARRAY_OBJECT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(boolean[]) returns <size>")
    public void Calling_getSizeOf_booleanArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_BOOL_EMPTY).filter(s -> s == ARRAY_BOOL_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_BOOL_VALUE).filter(s -> s == ARRAY_BOOL_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(byte[]) returns <size>")
    public void Calling_getSizeOf_byteArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_BYTE_EMPTY).filter(s -> s == ARRAY_BYTE_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_BYTE_VALUE).filter(s -> s == ARRAY_BYTE_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(char[]) returns <size>")
    public void Calling_getSizeOf_charArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_CHAR_EMPTY).filter(s -> s == ARRAY_CHAR_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_CHAR_VALUE).filter(s -> s == ARRAY_CHAR_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(double[]) returns <size>")
    public void Calling_getSizeOf_doubleArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_DOUBLE_EMPTY).filter(s -> s == ARRAY_DOUBLE_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_DOUBLE_VALUE).filter(s -> s == ARRAY_DOUBLE_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(float[]) returns <size>")
    public void Calling_getSizeOf_floatArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_FLOAT_EMPTY).filter(s -> s == ARRAY_FLOAT_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_FLOAT_VALUE).filter(s -> s == ARRAY_FLOAT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(int[]) returns <size>")
    public void Calling_getSizeOf_inttArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_INT_EMPTY).filter(s -> s == ARRAY_INT_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_INT_VALUE).filter(s -> s == ARRAY_INT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(long[]) returns <size>")
    public void Calling_getSizeOf_longArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_LONG_EMPTY).filter(s -> s == ARRAY_LONG_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_LONG_VALUE).filter(s -> s == ARRAY_LONG_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(short[]) returns <size>")
    public void Calling_getSizeOf_shortArr_returns_SIZE() {
        assertTrue(getSizeOf(ARRAY_SHORT_EMPTY).filter(s -> s == ARRAY_SHORT_EMPTY.length).isPresent());
        assertTrue(getSizeOf(ARRAY_SHORT_VALUE).filter(s -> s == ARRAY_SHORT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(boolean) returns Comparable")
    public void Calling_getComparableOf_boolean_returns_Comparable() {
        assertTrue(getComparableOf(BOOL_TRUE).isPresent());
        assertTrue(getComparableOf(BOOL_FALSE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(byte) returns Comparable")
    public void Calling_getComparableOf_byte_returns_Comparable() {
        assertTrue(getComparableOf(BYTE_NEG3).isPresent());
        assertTrue(getComparableOf(BYTE_ZERO).isPresent());
        assertTrue(getComparableOf(BYTE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(char) returns Comparable")
    public void Calling_getComparableOf_char_returns_Comparable() {
        assertTrue(getComparableOf(CHAR_0).isPresent());
        assertTrue(getComparableOf(CHAR_A).isPresent());
        assertTrue(getComparableOf(CHAR_M).isPresent());
        assertTrue(getComparableOf(CHAR_Z).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(double) returns Comparable")
    public void Calling_getComparableOf_double_returns_Comparable() {
        assertTrue(getComparableOf(DOUBLE_NEG3).isPresent());
        assertTrue(getComparableOf(DOUBLE_ZERO).isPresent());
        assertTrue(getComparableOf(DOUBLE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(float) returns Comparable")
    public void Calling_getComparableOf_float_returns_Comparable() {
        assertTrue(getComparableOf(FLOAT_NEG3).isPresent());
        assertTrue(getComparableOf(FLOAT_ZERO).isPresent());
        assertTrue(getComparableOf(FLOAT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(int) returns Comparable")
    public void Calling_getComparableOf_int_returns_Comparable() {
        assertTrue(getComparableOf(INT_NEG3).isPresent());
        assertTrue(getComparableOf(INT_ZERO).isPresent());
        assertTrue(getComparableOf(INT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(long) returns Comparable")
    public void Calling_getComparableOf_long_returns_Comparable() {
        assertTrue(getComparableOf(LONG_NEG3).isPresent());
        assertTrue(getComparableOf(LONG_ZERO).isPresent());
        assertTrue(getComparableOf(LONG_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(short) returns Comparable")
    public void Calling_getComparableOf_short_returns_Comparable() {
        assertTrue(getComparableOf(SHORT_NEG3).isPresent());
        assertTrue(getComparableOf(SHORT_ZERO).isPresent());
        assertTrue(getComparableOf(SHORT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(null) returns EMPTY")
    public void Calling_getComparableOf_null_returns_EMPTY() {
        assertFalse(getComparableOf(NUMBER_NULL).isPresent());
        assertFalse(getComparableOf(OBJECT_NULL).isPresent());
        assertFalse(getComparableOf(STRING_NULL).isPresent());
        assertFalse(getComparableOf(LIST_NULL).isPresent());
        assertFalse(getComparableOf(MAP_NULL).isPresent());
        assertFalse(getComparableOf(SET_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_OBJECT_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_BOOL_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_BYTE_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_CHAR_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_DOUBLE_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_FLOAT_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_INT_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_LONG_NULL).isPresent());
        assertFalse(getComparableOf(ARRAY_SHORT_NULL).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Number) returns Comparable")
    public void Calling_getComparableOf_Number_returns_Comparable() {
        assertTrue(getComparableOf(NUMBER_NEG3).isPresent());
        assertTrue(getComparableOf(NUMBER_ZERO).isPresent());
        assertTrue(getComparableOf(NUMBER_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Object) returns EMPTY")
    public void Calling_getComparableOf_Object_returns_EMPTY() {
        assertFalse(getComparableOf(OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(String) returns Comparable")
    public void Calling_getComparableOf_String_returns_Comparable() {
        assertTrue(getComparableOf(STRING_EMPTY).isPresent());
        assertTrue(getComparableOf(STRING_ABC).isPresent());
        assertTrue(getComparableOf(STRING_XYZ).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(List) returns EMPTY")
    public void Calling_getComparableOf_List_returns_EMPTY() {
        assertFalse(getComparableOf(LIST_EMPTY).isPresent());
        assertFalse(getComparableOf(LIST_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Map) returns EMPTY")
    public void Calling_getComparableOf_Map_returns_EMPTY() {
        assertFalse(getComparableOf(MAP_EMPTY).isPresent());
        assertFalse(getComparableOf(MAP_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Set) returns EMPTY")
    public void Calling_getComparableOf_Set_returns_EMPTY() {
        assertFalse(getComparableOf(SET_EMPTY).isPresent());
        assertFalse(getComparableOf(SET_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Object[]) returns EMPTY")
    public void Calling_getComparableOf_ObjectArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_OBJECT_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(boolean[]) returns EMPTY")
    public void Calling_getComparableOf_BooleanArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_BOOL_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_BOOL_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(byte[]) returns EMPTY")
    public void Calling_getComparableOf_byteArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_BYTE_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_BYTE_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(char[]) returns EMPTY")
    public void Calling_getComparableOf_charArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_CHAR_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_CHAR_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(double[]) returns EMPTY")
    public void Calling_getComparableOf_doubleArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_DOUBLE_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_DOUBLE_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(float[]) returns EMPTY")
    public void Calling_getComparableOf_floatArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_FLOAT_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_FLOAT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(int[]) returns EMPTY")
    public void Calling_getComparableOf_intArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_INT_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_INT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(long[]) returns EMPTY")
    public void Calling_getComparableOf_longArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_LONG_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_LONG_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(short[]) returns EMPTY")
    public void Calling_getComparableOf_shortArr_returns_EMPTY() {
        assertFalse(getComparableOf(ARRAY_SHORT_EMPTY).isPresent());
        assertFalse(getComparableOf(ARRAY_SHORT_VALUE).isPresent());
    }
}
