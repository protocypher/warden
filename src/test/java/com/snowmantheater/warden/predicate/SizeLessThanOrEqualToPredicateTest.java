package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SizeLessThanOrEqualToPredicateTest {
    @Test
    @DisplayName("Testing test(boolean t)")
    public void testing_test_where_Type_is_boolean() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(BOOL_TRUE));
        assertFalse(predicate.test(BOOL_FALSE));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(BOOL_TRUE));
        assertFalse(predicate.test(BOOL_FALSE));
    }

    @Test
    @DisplayName("Testing test(byte t)")
    public void testing_test_where_Type_is_byte() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(BYTE_NEG3));
        assertFalse(predicate.test(BYTE_ZERO));
        assertFalse(predicate.test(BYTE_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(BYTE_NEG3));
        assertFalse(predicate.test(BYTE_ZERO));
        assertFalse(predicate.test(BYTE_POS3));
    }

    @Test
    @DisplayName("Testing test(char t)")
    public void testing_test_where_Type_is_char() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(CHAR_0));
        assertFalse(predicate.test(CHAR_A));
        assertFalse(predicate.test(CHAR_M));
        assertFalse(predicate.test(CHAR_Z));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(CHAR_0));
        assertFalse(predicate.test(CHAR_A));
        assertFalse(predicate.test(CHAR_M));
        assertFalse(predicate.test(CHAR_Z));
    }

    @Test
    @DisplayName("Testing test(double t)")
    public void testing_test_where_Type_is_double() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(DOUBLE_NEG3));
        assertFalse(predicate.test(DOUBLE_ZERO));
        assertFalse(predicate.test(DOUBLE_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(DOUBLE_NEG3));
        assertFalse(predicate.test(DOUBLE_ZERO));
        assertFalse(predicate.test(DOUBLE_POS3));
    }

    @Test
    @DisplayName("Testing test(float t)")
    public void testing_test_where_Type_is_float() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(FLOAT_NEG3));
        assertFalse(predicate.test(FLOAT_ZERO));
        assertFalse(predicate.test(FLOAT_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(FLOAT_NEG3));
        assertFalse(predicate.test(FLOAT_ZERO));
        assertFalse(predicate.test(FLOAT_POS3));
    }

    @Test
    @DisplayName("Testing test(int t)")
    public void testing_test_where_Type_is_int() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(INT_NEG3));
        assertFalse(predicate.test(INT_ZERO));
        assertFalse(predicate.test(INT_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(INT_NEG3));
        assertFalse(predicate.test(INT_ZERO));
        assertFalse(predicate.test(INT_POS3));
    }

    @Test
    @DisplayName("Testing test(long t)")
    public void testing_test_where_Type_is_long() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(LONG_NEG3));
        assertFalse(predicate.test(LONG_ZERO));
        assertFalse(predicate.test(LONG_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(LONG_NEG3));
        assertFalse(predicate.test(LONG_ZERO));
        assertFalse(predicate.test(LONG_POS3));
    }

    @Test
    @DisplayName("Testing test(short t)")
    public void testing_test_where_Type_is_short() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(SHORT_NEG3));
        assertFalse(predicate.test(SHORT_ZERO));
        assertFalse(predicate.test(SHORT_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(SHORT_NEG3));
        assertFalse(predicate.test(SHORT_ZERO));
        assertFalse(predicate.test(SHORT_POS3));
    }

    @Test
    @DisplayName("Testing test(Number t)")
    public void testing_test_where_Type_is_Number() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(NUMBER_NULL));
        assertFalse(predicate.test(NUMBER_NEG3));
        assertFalse(predicate.test(NUMBER_ZERO));
        assertFalse(predicate.test(NUMBER_POS3));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(NUMBER_NULL));
        assertFalse(predicate.test(NUMBER_NEG3));
        assertFalse(predicate.test(NUMBER_ZERO));
        assertFalse(predicate.test(NUMBER_POS3));
    }

    @Test
    @DisplayName("Testing test(Object t)")
    public void testing_test_where_Type_is_Object() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(OBJECT_NULL));
        assertFalse(predicate.test(OBJECT_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(1);
        assertFalse(predicate.test(OBJECT_NULL));
        assertFalse(predicate.test(OBJECT_VALUE));
    }

    @Test
    @DisplayName("Testing test(String t)")
    public void testing_test_where_Type_is_String() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(STRING_NULL));
        assertTrue(predicate.test(STRING_EMPTY));
        assertFalse(predicate.test(STRING_ABC));
        assertFalse(predicate.test(STRING_XYZ));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(STRING_NULL));
        assertTrue(predicate.test(STRING_EMPTY));
        assertTrue(predicate.test(STRING_ABC));
        assertTrue(predicate.test(STRING_XYZ));
    }

    @Test
    @DisplayName("Testing test(List t)")
    public void testing_test_where_Type_is_List() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(LIST_NULL));
        assertTrue(predicate.test(LIST_EMPTY));
        assertFalse(predicate.test(LIST_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(LIST_NULL));
        assertTrue(predicate.test(LIST_EMPTY));
        assertTrue(predicate.test(LIST_VALUE));
    }

    @Test
    @DisplayName("Testing test(Map t)")
    public void testing_test_where_Type_is_Map() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(MAP_NULL));
        assertTrue(predicate.test(MAP_EMPTY));
        assertFalse(predicate.test(MAP_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(MAP_NULL));
        assertTrue(predicate.test(MAP_EMPTY));
        assertTrue(predicate.test(MAP_VALUE));
    }

    @Test
    @DisplayName("Testing test(Set t)")
    public void testing_test_where_Type_is_Set() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(SET_NULL));
        assertTrue(predicate.test(SET_EMPTY));
        assertFalse(predicate.test(SET_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(SET_NULL));
        assertTrue(predicate.test(SET_EMPTY));
        assertTrue(predicate.test(SET_VALUE));
    }

    @Test
    @DisplayName("Testing test(Object[] t)")
    public void testing_test_where_Type_is_ObjectArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_OBJECT_NULL));
        assertTrue(predicate.test(ARRAY_OBJECT_EMPTY));
        assertFalse(predicate.test(ARRAY_OBJECT_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_OBJECT_NULL));
        assertTrue(predicate.test(ARRAY_OBJECT_EMPTY));
        assertTrue(predicate.test(ARRAY_OBJECT_VALUE));
    }

    @Test
    @DisplayName("Testing test(boolean[] t)")
    public void testing_test_where_Type_is_booleanArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_BOOL_NULL));
        assertTrue(predicate.test(ARRAY_BOOL_EMPTY));
        assertFalse(predicate.test(ARRAY_BOOL_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_BOOL_NULL));
        assertTrue(predicate.test(ARRAY_BOOL_EMPTY));
        assertTrue(predicate.test(ARRAY_BOOL_VALUE));
    }

    @Test
    @DisplayName("Testing test(byte[] t)")
    public void testing_test_where_Type_is_byteArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_BYTE_NULL));
        assertTrue(predicate.test(ARRAY_BYTE_EMPTY));
        assertFalse(predicate.test(ARRAY_BYTE_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_BYTE_NULL));
        assertTrue(predicate.test(ARRAY_BYTE_EMPTY));
        assertTrue(predicate.test(ARRAY_BYTE_VALUE));
    }

    @Test
    @DisplayName("Testing test(char[] t)")
    public void testing_test_where_Type_is_charArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_CHAR_NULL));
        assertTrue(predicate.test(ARRAY_CHAR_EMPTY));
        assertFalse(predicate.test(ARRAY_CHAR_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_CHAR_NULL));
        assertTrue(predicate.test(ARRAY_CHAR_EMPTY));
        assertTrue(predicate.test(ARRAY_CHAR_VALUE));
    }

    @Test
    @DisplayName("Testing test(double[] t)")
    public void testing_test_where_Type_is_doubleArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_DOUBLE_NULL));
        assertTrue(predicate.test(ARRAY_DOUBLE_EMPTY));
        assertFalse(predicate.test(ARRAY_DOUBLE_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_DOUBLE_NULL));
        assertTrue(predicate.test(ARRAY_DOUBLE_EMPTY));
        assertTrue(predicate.test(ARRAY_DOUBLE_VALUE));
    }

    @Test
    @DisplayName("Testing test(float[] t)")
    public void testing_test_where_Type_is_floatArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_FLOAT_NULL));
        assertTrue(predicate.test(ARRAY_FLOAT_EMPTY));
        assertFalse(predicate.test(ARRAY_FLOAT_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_FLOAT_NULL));
        assertTrue(predicate.test(ARRAY_FLOAT_EMPTY));
        assertTrue(predicate.test(ARRAY_FLOAT_VALUE));
    }

    @Test
    @DisplayName("Testing test(int[] t)")
    public void testing_test_where_Type_is_intArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_INT_NULL));
        assertTrue(predicate.test(ARRAY_INT_EMPTY));
        assertFalse(predicate.test(ARRAY_INT_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_INT_NULL));
        assertTrue(predicate.test(ARRAY_INT_EMPTY));
        assertTrue(predicate.test(ARRAY_INT_VALUE));
    }

    @Test
    @DisplayName("Testing test(long[] t)")
    public void testing_test_where_Type_is_longArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_LONG_NULL));
        assertTrue(predicate.test(ARRAY_LONG_EMPTY));
        assertFalse(predicate.test(ARRAY_LONG_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_LONG_NULL));
        assertTrue(predicate.test(ARRAY_LONG_EMPTY));
        assertTrue(predicate.test(ARRAY_LONG_VALUE));
    }

    @Test
    @DisplayName("Testing test(short[] t)")
    public void testing_test_where_Type_is_shortArr() {
        Predicate<Object> predicate;

        predicate = new SizeLessThanOrEqualToPredicate(0);
        assertFalse(predicate.test(ARRAY_SHORT_NULL));
        assertTrue(predicate.test(ARRAY_SHORT_EMPTY));
        assertFalse(predicate.test(ARRAY_SHORT_VALUE));

        predicate = new SizeLessThanOrEqualToPredicate(3);
        assertFalse(predicate.test(ARRAY_SHORT_NULL));
        assertTrue(predicate.test(ARRAY_SHORT_EMPTY));
        assertTrue(predicate.test(ARRAY_SHORT_VALUE));
    }

    @Test
    @DisplayName("Calling negate() returns instanceof AssertSizeGreaterThan")
    public void calling_negate_returns_instanceof_AssertSizeGreaterThan() {
        Predicate<Object> predicate = new SizeLessThanOrEqualToPredicate(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(SizeGreaterThanPredicate.class, negated.getClass());
    }
}
