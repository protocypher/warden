package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {
    @Test
    @DisplayName("Calling getSizeOf(boolean) returns EMPTY")
    public void Calling_getSizeOf_boolean_returns_EMPTY() {
        assertFalse(Util.getSizeOf(BOOL_FALSE).isPresent());
        assertFalse(Util.getSizeOf(BOOL_TRUE).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(byte) returns EMPTY")
    public void Calling_getSizeOf_byte_returns_EMPTY() {
        assertFalse(Util.getSizeOf(BYTE_NEG3).isPresent());
        assertFalse(Util.getSizeOf(BYTE_ZERO).isPresent());
        assertFalse(Util.getSizeOf(BYTE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(char) returns EMPTY")
    public void Calling_getSizeOf_char_returns_EMPTY() {
        assertFalse(Util.getSizeOf(CHAR_0).isPresent());
        assertFalse(Util.getSizeOf(CHAR_A).isPresent());
        assertFalse(Util.getSizeOf(CHAR_M).isPresent());
        assertFalse(Util.getSizeOf(CHAR_Z).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(double) returns EMPTY")
    public void Calling_getSizeOf_double_returns_EMPTY() {
        assertFalse(Util.getSizeOf(DOUBLE_NEG3).isPresent());
        assertFalse(Util.getSizeOf(DOUBLE_ZERO).isPresent());
        assertFalse(Util.getSizeOf(DOUBLE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(float) returns EMPTY")
    public void Calling_getSizeOf_float_returns_EMPTY() {
        assertFalse(Util.getSizeOf(FLOAT_NEG3).isPresent());
        assertFalse(Util.getSizeOf(FLOAT_ZERO).isPresent());
        assertFalse(Util.getSizeOf(FLOAT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(int) returns EMPTY")
    public void Calling_getSizeOf_int_returns_EMPTY() {
        assertFalse(Util.getSizeOf(INT_NEG3).isPresent());
        assertFalse(Util.getSizeOf(INT_ZERO).isPresent());
        assertFalse(Util.getSizeOf(INT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(long) returns EMPTY")
    public void Calling_getSizeOf_long_returns_EMPTY() {
        assertFalse(Util.getSizeOf(LONG_NEG3).isPresent());
        assertFalse(Util.getSizeOf(LONG_ZERO).isPresent());
        assertFalse(Util.getSizeOf(LONG_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(short) returns EMPTY")
    public void Calling_getSizeOf_short_returns_EMPTY() {
        assertFalse(Util.getSizeOf(SHORT_NEG3).isPresent());
        assertFalse(Util.getSizeOf(SHORT_ZERO).isPresent());
        assertFalse(Util.getSizeOf(SHORT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(null) returns EMPTY")
    public void Calling_getSizeOf_null_returns_EMPTY() {
        assertFalse(Util.getSizeOf(NUMBER_NULL).isPresent());
        assertFalse(Util.getSizeOf(OBJECT_NULL).isPresent());
        assertFalse(Util.getSizeOf(STRING_NULL).isPresent());
        assertFalse(Util.getSizeOf(LIST_NULL).isPresent());
        assertFalse(Util.getSizeOf(MAP_NULL).isPresent());
        assertFalse(Util.getSizeOf(SET_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_OBJECT_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_BOOL_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_BYTE_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_CHAR_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_DOUBLE_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_FLOAT_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_INT_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_LONG_NULL).isPresent());
        assertFalse(Util.getSizeOf(ARRAY_SHORT_NULL).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Number) returns EMPTY")
    public void Calling_getSizeOf_Number_returns_EMPTY() {
        assertFalse(Util.getSizeOf(NUMBER_NEG3).isPresent());
        assertFalse(Util.getSizeOf(NUMBER_ZERO).isPresent());
        assertFalse(Util.getSizeOf(NUMBER_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Object) returns EMPTY")
    public void Calling_getSizeOf_Object_returns_EMPTY() {
        assertFalse(Util.getSizeOf(OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(String) returns <size>")
    public void Calling_getSizeOf_String_returns_SIZE() {
        assertTrue(Util.getSizeOf(STRING_EMPTY).filter(s -> s == STRING_EMPTY.length()).isPresent());
        assertTrue(Util.getSizeOf(STRING_ABC).filter(s -> s == STRING_ABC.length()).isPresent());
        assertTrue(Util.getSizeOf(STRING_XYZ).filter(s -> s == STRING_XYZ.length()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(List) returns <size>")
    public void Calling_getSizeOf_List_returns_SIZE() {
        assertTrue(Util.getSizeOf(LIST_EMPTY).filter(s -> s == LIST_EMPTY.size()).isPresent());
        assertTrue(Util.getSizeOf(LIST_VALUE).filter(s -> s == LIST_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Map) returns <size>")
    public void Calling_getSizeOf_Map_returns_SIZE() {
        assertTrue(Util.getSizeOf(MAP_EMPTY).filter(s -> s == MAP_EMPTY.size()).isPresent());
        assertTrue(Util.getSizeOf(MAP_VALUE).filter(s -> s == MAP_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Set) returns <size>")
    public void Calling_getSizeOf_Set_returns_SIZE() {
        assertTrue(Util.getSizeOf(SET_EMPTY).filter(s -> s == SET_EMPTY.size()).isPresent());
        assertTrue(Util.getSizeOf(SET_VALUE).filter(s -> s == SET_VALUE.size()).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(Object[]) returns <size>")
    public void Calling_getSizeOf_ObjectArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_OBJECT_EMPTY).filter(s -> s == ARRAY_OBJECT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_OBJECT_VALUE).filter(s -> s == ARRAY_OBJECT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(boolean[]) returns <size>")
    public void Calling_getSizeOf_booleanArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_BOOL_EMPTY).filter(s -> s == ARRAY_BOOL_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_BOOL_VALUE).filter(s -> s == ARRAY_BOOL_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(byte[]) returns <size>")
    public void Calling_getSizeOf_byteArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_BYTE_EMPTY).filter(s -> s == ARRAY_BYTE_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_BYTE_VALUE).filter(s -> s == ARRAY_BYTE_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(char[]) returns <size>")
    public void Calling_getSizeOf_charArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_CHAR_EMPTY).filter(s -> s == ARRAY_CHAR_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_CHAR_VALUE).filter(s -> s == ARRAY_CHAR_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(double[]) returns <size>")
    public void Calling_getSizeOf_doubleArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_DOUBLE_EMPTY).filter(s -> s == ARRAY_DOUBLE_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_DOUBLE_VALUE).filter(s -> s == ARRAY_DOUBLE_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(float[]) returns <size>")
    public void Calling_getSizeOf_floatArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_FLOAT_EMPTY).filter(s -> s == ARRAY_FLOAT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_FLOAT_VALUE).filter(s -> s == ARRAY_FLOAT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(int[]) returns <size>")
    public void Calling_getSizeOf_inttArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_INT_EMPTY).filter(s -> s == ARRAY_INT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_INT_VALUE).filter(s -> s == ARRAY_INT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(long[]) returns <size>")
    public void Calling_getSizeOf_longArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_LONG_EMPTY).filter(s -> s == ARRAY_LONG_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_LONG_VALUE).filter(s -> s == ARRAY_LONG_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getSizeOf(short[]) returns <size>")
    public void Calling_getSizeOf_shortArr_returns_SIZE() {
        assertTrue(Util.getSizeOf(ARRAY_SHORT_EMPTY).filter(s -> s == ARRAY_SHORT_EMPTY.length).isPresent());
        assertTrue(Util.getSizeOf(ARRAY_SHORT_VALUE).filter(s -> s == ARRAY_SHORT_VALUE.length).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(boolean) returns Comparable")
    public void Calling_getComparableOf_boolean_returns_Comparable() {
        assertTrue(Util.getComparableOf(BOOL_TRUE).isPresent());
        assertTrue(Util.getComparableOf(BOOL_FALSE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(byte) returns Comparable")
    public void Calling_getComparableOf_byte_returns_Comparable() {
        assertTrue(Util.getComparableOf(BYTE_NEG3).isPresent());
        assertTrue(Util.getComparableOf(BYTE_ZERO).isPresent());
        assertTrue(Util.getComparableOf(BYTE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(char) returns Comparable")
    public void Calling_getComparableOf_char_returns_Comparable() {
        assertTrue(Util.getComparableOf(CHAR_0).isPresent());
        assertTrue(Util.getComparableOf(CHAR_A).isPresent());
        assertTrue(Util.getComparableOf(CHAR_M).isPresent());
        assertTrue(Util.getComparableOf(CHAR_Z).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(double) returns Comparable")
    public void Calling_getComparableOf_double_returns_Comparable() {
        assertTrue(Util.getComparableOf(DOUBLE_NEG3).isPresent());
        assertTrue(Util.getComparableOf(DOUBLE_ZERO).isPresent());
        assertTrue(Util.getComparableOf(DOUBLE_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(float) returns Comparable")
    public void Calling_getComparableOf_float_returns_Comparable() {
        assertTrue(Util.getComparableOf(FLOAT_NEG3).isPresent());
        assertTrue(Util.getComparableOf(FLOAT_ZERO).isPresent());
        assertTrue(Util.getComparableOf(FLOAT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(int) returns Comparable")
    public void Calling_getComparableOf_int_returns_Comparable() {
        assertTrue(Util.getComparableOf(INT_NEG3).isPresent());
        assertTrue(Util.getComparableOf(INT_ZERO).isPresent());
        assertTrue(Util.getComparableOf(INT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(long) returns Comparable")
    public void Calling_getComparableOf_long_returns_Comparable() {
        assertTrue(Util.getComparableOf(LONG_NEG3).isPresent());
        assertTrue(Util.getComparableOf(LONG_ZERO).isPresent());
        assertTrue(Util.getComparableOf(LONG_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(short) returns Comparable")
    public void Calling_getComparableOf_short_returns_Comparable() {
        assertTrue(Util.getComparableOf(SHORT_NEG3).isPresent());
        assertTrue(Util.getComparableOf(SHORT_ZERO).isPresent());
        assertTrue(Util.getComparableOf(SHORT_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(null) returns EMPTY")
    public void Calling_getComparableOf_null_returns_EMPTY() {
        assertFalse(Util.getComparableOf(NUMBER_NULL).isPresent());
        assertFalse(Util.getComparableOf(OBJECT_NULL).isPresent());
        assertFalse(Util.getComparableOf(STRING_NULL).isPresent());
        assertFalse(Util.getComparableOf(LIST_NULL).isPresent());
        assertFalse(Util.getComparableOf(MAP_NULL).isPresent());
        assertFalse(Util.getComparableOf(SET_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_OBJECT_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_BOOL_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_BYTE_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_CHAR_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_DOUBLE_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_FLOAT_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_INT_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_LONG_NULL).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_SHORT_NULL).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Number) returns Comparable")
    public void Calling_getComparableOf_Number_returns_Comparable() {
        assertTrue(Util.getComparableOf(NUMBER_NEG3).isPresent());
        assertTrue(Util.getComparableOf(NUMBER_ZERO).isPresent());
        assertTrue(Util.getComparableOf(NUMBER_POS3).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Object) returns EMPTY")
    public void Calling_getComparableOf_Object_returns_EMPTY() {
        assertFalse(Util.getComparableOf(OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(String) returns Comparable")
    public void Calling_getComparableOf_String_returns_Comparable() {
        assertTrue(Util.getComparableOf(STRING_EMPTY).isPresent());
        assertTrue(Util.getComparableOf(STRING_ABC).isPresent());
        assertTrue(Util.getComparableOf(STRING_XYZ).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(List) returns EMPTY")
    public void Calling_getComparableOf_List_returns_EMPTY() {
        assertFalse(Util.getComparableOf(LIST_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(LIST_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Map) returns EMPTY")
    public void Calling_getComparableOf_Map_returns_EMPTY() {
        assertFalse(Util.getComparableOf(MAP_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(MAP_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Set) returns EMPTY")
    public void Calling_getComparableOf_Set_returns_EMPTY() {
        assertFalse(Util.getComparableOf(SET_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(SET_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(Object[]) returns EMPTY")
    public void Calling_getComparableOf_ObjectArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_OBJECT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_OBJECT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(boolean[]) returns EMPTY")
    public void Calling_getComparableOf_BooleanArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_BOOL_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_BOOL_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(byte[]) returns EMPTY")
    public void Calling_getComparableOf_byteArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_BYTE_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_BYTE_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(char[]) returns EMPTY")
    public void Calling_getComparableOf_charArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_CHAR_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_CHAR_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(double[]) returns EMPTY")
    public void Calling_getComparableOf_doubleArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_DOUBLE_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_DOUBLE_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(float[]) returns EMPTY")
    public void Calling_getComparableOf_floatArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_FLOAT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_FLOAT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(int[]) returns EMPTY")
    public void Calling_getComparableOf_intArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_INT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_INT_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(long[]) returns EMPTY")
    public void Calling_getComparableOf_longArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_LONG_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_LONG_VALUE).isPresent());
    }

    @Test
    @DisplayName("Calling getComparableOf(short[]) returns EMPTY")
    public void Calling_getComparableOf_shortArr_returns_EMPTY() {
        assertFalse(Util.getComparableOf(ARRAY_SHORT_EMPTY).isPresent());
        assertFalse(Util.getComparableOf(ARRAY_SHORT_VALUE).isPresent());
    }
}
