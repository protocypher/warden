package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.ValidationData.*;
import static org.junit.jupiter.api.Assertions.*;

class NotEqualToPredicateTest {
    @Test
    @DisplayName("Testing test(boolean t)")
    public void testing_test_where_Type_is_boolean() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(true);
        assertFalse(predicate.test(BOOL_TRUE));
        assertTrue(predicate.test(BOOL_FALSE));

        predicate = new AssertNotEqualTo(0L);
        assertTrue(predicate.test(BOOL_TRUE));
        assertTrue(predicate.test(BOOL_FALSE));
    }

    @Test
    @DisplayName("Testing test(byte t)")
    public void testing_test_where_Type_is_byte() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo((byte)3);
        assertTrue(predicate.test(BYTE_NEG3));
        assertTrue(predicate.test(BYTE_ZERO));
        assertFalse(predicate.test(BYTE_POS3));

        predicate = new AssertNotEqualTo((char)3);
        assertTrue(predicate.test(BYTE_NEG3));
        assertTrue(predicate.test(BYTE_ZERO));
        assertTrue(predicate.test(BYTE_POS3));
    }

    @Test
    @DisplayName("Testing test(char t)")
    public void testing_test_where_Type_is_char() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo('Z');
        assertTrue(predicate.test(CHAR_0));
        assertTrue(predicate.test(CHAR_A));
        assertFalse(predicate.test(CHAR_Z));

        predicate = new AssertNotEqualTo(false);
        assertTrue(predicate.test(CHAR_0));
        assertTrue(predicate.test(CHAR_A));
        assertTrue(predicate.test(CHAR_Z));
    }

    @Test
    @DisplayName("Testing test(double t)")
    public void testing_test_where_Type_is_double() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(3.3D);
        assertTrue(predicate.test(DOUBLE_NEG3));
        assertTrue(predicate.test(DOUBLE_ZERO));
        assertFalse(predicate.test(DOUBLE_POS3));

        predicate = new AssertNotEqualTo(false);
        assertTrue(predicate.test(DOUBLE_NEG3));
        assertTrue(predicate.test(DOUBLE_ZERO));
        assertTrue(predicate.test(DOUBLE_POS3));
    }

    @Test
    @DisplayName("Testing test(float t)")
    public void testing_test_where_Type_is_float() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(3.3F);
        assertTrue(predicate.test(FLOAT_NEG3));
        assertTrue(predicate.test(FLOAT_ZERO));
        assertFalse(predicate.test(FLOAT_POS3));

        predicate = new AssertNotEqualTo(false);
        assertTrue(predicate.test(FLOAT_NEG3));
        assertTrue(predicate.test(FLOAT_ZERO));
        assertTrue(predicate.test(FLOAT_POS3));
    }

    @Test
    @DisplayName("Testing test(int t)")
    public void testing_test_where_Type_is_int() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(3);
        assertTrue(predicate.test(INT_NEG3));
        assertTrue(predicate.test(INT_ZERO));
        assertFalse(predicate.test(INT_POS3));

        predicate = new AssertNotEqualTo((char)3);
        assertTrue(predicate.test(INT_NEG3));
        assertTrue(predicate.test(INT_ZERO));
        assertTrue(predicate.test(INT_POS3));
    }

    @Test
    @DisplayName("Testing test(long t)")
    public void testing_test_where_Type_is_long() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(3L);
        assertTrue(predicate.test(LONG_NEG3));
        assertTrue(predicate.test(LONG_ZERO));
        assertFalse(predicate.test(LONG_POS3));

        predicate = new AssertNotEqualTo((char)3);
        assertTrue(predicate.test(LONG_NEG3));
        assertTrue(predicate.test(LONG_ZERO));
        assertTrue(predicate.test(LONG_POS3));
    }

    @Test
    @DisplayName("Testing test(short t)")
    public void testing_test_where_Type_is_short() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo((short)3);
        assertTrue(predicate.test(SHORT_NEG3));
        assertTrue(predicate.test(SHORT_ZERO));
        assertFalse(predicate.test(SHORT_POS3));

        predicate = new AssertNotEqualTo(false);
        assertTrue(predicate.test(SHORT_NEG3));
        assertTrue(predicate.test(SHORT_ZERO));
        assertTrue(predicate.test(SHORT_POS3));
    }

    @Test
    @DisplayName("Testing test(Number t)")
    public void testing_test_where_Type_is_Number() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(null);
        assertFalse(predicate.test(NUMBER_NULL));
        assertTrue(predicate.test(NUMBER_NEG3));
        assertTrue(predicate.test(NUMBER_ZERO));
        assertTrue(predicate.test(NUMBER_POS3));

        predicate = new AssertNotEqualTo(3);
        assertTrue(predicate.test(NUMBER_NULL));
        assertTrue(predicate.test(NUMBER_NEG3));
        assertTrue(predicate.test(NUMBER_ZERO));
        assertFalse(predicate.test(NUMBER_POS3));
    }

    @Test
    @DisplayName("Testing test(Object t)")
    public void testing_test_where_Type_is_Object() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(null);
        assertFalse(predicate.test(OBJECT_NULL));
        assertTrue(predicate.test(OBJECT_VALUE));

        predicate = new AssertNotEqualTo(OBJECT_VALUE);
        assertTrue(predicate.test(OBJECT_NULL));
        assertFalse(predicate.test(OBJECT_VALUE));
    }

    @Test
    @DisplayName("Testing test(String t)")
    public void testing_test_where_Type_is_String() {
        Predicate<Object> predicate;

        predicate = new AssertNotEqualTo(null);
        assertFalse(predicate.test(STRING_NULL));
        assertTrue(predicate.test(STRING_EMPTY));
        assertTrue(predicate.test(STRING_ABC));
        assertTrue(predicate.test(STRING_XYZ));

        predicate = new AssertNotEqualTo("ABC");
        assertTrue(predicate.test(STRING_NULL));
        assertTrue(predicate.test(STRING_EMPTY));
        assertFalse(predicate.test(STRING_ABC));
        assertTrue(predicate.test(STRING_XYZ));
    }

    @Test
    @DisplayName("Testing test(List t)")
    public void test_testing_where_Type_is_List() {
        Predicate<Object> predicate = new AssertNotEqualTo(Collections.emptyList());
        assertTrue(predicate.test(LIST_NULL));
        assertFalse(predicate.test(LIST_EMPTY));
        assertTrue(predicate.test(LIST_VALUE));
    }

    @Test
    @DisplayName("Testing test(Map t)")
    public void test_testing_where_Type_is_Map() {
        Predicate<Object> predicate = new AssertNotEqualTo(Collections.emptyMap());
        assertTrue(predicate.test(MAP_NULL));
        assertFalse(predicate.test(MAP_EMPTY));
        assertTrue(predicate.test(MAP_VALUE));
    }

    @Test
    @DisplayName("Testing test(Set t)")
    public void test_testing_where_Type_is_Set() {
        Predicate<Object> predicate = new AssertNotEqualTo(Collections.emptySet());
        assertTrue(predicate.test(SET_NULL));
        assertFalse(predicate.test(SET_EMPTY));
        assertTrue(predicate.test(SET_VALUE));
    }

    @Test
    @DisplayName("Testing test(Object[] t)")
    public void test_testing_where_Type_is_ObjectArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new Object[] { });
        assertTrue(predicate.test(ARRAY_OBJECT_NULL));
        assertFalse(predicate.test(ARRAY_OBJECT_EMPTY));
        assertTrue(predicate.test(ARRAY_OBJECT_VALUE));
    }

    @Test
    @DisplayName("Testing test(boolean[] t)")
    public void test_testing_where_Type_is_booleanArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new boolean[] { });
        assertTrue(predicate.test(ARRAY_BOOL_NULL));
        assertFalse(predicate.test(ARRAY_BOOL_EMPTY));
        assertTrue(predicate.test(ARRAY_BOOL_VALUE));
    }

    @Test
    @DisplayName("Testing test(byte[] t)")
    public void test_testing_where_Type_is_byteArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new byte[] {1, 2, 3});
        assertTrue(predicate.test(ARRAY_BYTE_NULL));
        assertTrue(predicate.test(ARRAY_BYTE_EMPTY));
        assertFalse(predicate.test(ARRAY_BYTE_VALUE));
    }

    @Test
    @DisplayName("Testing test(char[] t)")
    public void test_testing_where_Type_is_charArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new char[] {'A', 'B', 'C'});
        assertTrue(predicate.test(ARRAY_CHAR_NULL));
        assertTrue(predicate.test(ARRAY_CHAR_EMPTY));
        assertFalse(predicate.test(ARRAY_CHAR_VALUE));
    }

    @Test
    @DisplayName("Testing test(double[] t)")
    public void test_testing_where_Type_is_doubleArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new double[] { });
        assertTrue(predicate.test(ARRAY_DOUBLE_NULL));
        assertFalse(predicate.test(ARRAY_DOUBLE_EMPTY));
        assertTrue(predicate.test(ARRAY_DOUBLE_VALUE));
    }

    @Test
    @DisplayName("Testing test(float[] t)")
    public void test_testing_where_Type_is_floatArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new float[] { });
        assertTrue(predicate.test(ARRAY_FLOAT_NULL));
        assertFalse(predicate.test(ARRAY_FLOAT_EMPTY));
        assertTrue(predicate.test(ARRAY_FLOAT_VALUE));
    }

    @Test
    @DisplayName("Testing test(int[] t)")
    public void test_testing_where_Type_is_intArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new int[] { });
        assertTrue(predicate.test(ARRAY_INT_NULL));
        assertFalse(predicate.test(ARRAY_INT_EMPTY));
        assertTrue(predicate.test(ARRAY_INT_VALUE));
    }

    @Test
    @DisplayName("Testing test(long[] t)")
    public void test_testing_where_Type_is_longArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new long[] { });
        assertTrue(predicate.test(ARRAY_LONG_NULL));
        assertFalse(predicate.test(ARRAY_LONG_EMPTY));
        assertTrue(predicate.test(ARRAY_LONG_VALUE));
    }

    @Test
    @DisplayName("Testing test(short[] t)")
    public void test_testing_where_Type_is_shortArr() {
        Predicate<Object> predicate = new AssertNotEqualTo(new short[] { });
        assertTrue(predicate.test(ARRAY_SHORT_NULL));
        assertFalse(predicate.test(ARRAY_SHORT_EMPTY));
        assertTrue(predicate.test(ARRAY_SHORT_VALUE));
    }

    @Test
    @DisplayName("Calling negate() returns instanceof AssertEqualTo")
    public void calling_negate_returns_instanceof_AssertEqualTo() {
        Predicate<Object> predicate = new AssertNotEqualTo(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(AssertEqualTo.class, negated.getClass());
    }
}