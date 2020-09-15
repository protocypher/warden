package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.GreaterThanPredicate.isAfter;
import static com.snowmantheater.warden.predicate.GreaterThanPredicate.isGreaterThan;
import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreaterThanPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(isGreaterThan(true)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(false)).to(BOOL_TRUE).allMatch(TRUE));
        assertTrue(apply(isGreaterThan(false)).to(BOOL_FALSE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(0)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(1)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));

        assertTrue(apply(isGreaterThan((byte)0)).to(BYTE_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan((byte)0)).to(BYTE_NEG3, BYTE_ZERO).allMatch(FALSE));
        assertTrue(apply(isGreaterThan((char)0)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));

        assertTrue(apply(isAfter('M')).to(CHAR_Z).allMatch(TRUE));
        assertTrue(apply(isAfter('M')).to(CHAR_A, CHAR_M).allMatch(FALSE));
        assertTrue(apply(isAfter(false)).to(CHAR_A, CHAR_M, CHAR_Z).allMatch(FALSE));

        assertTrue(apply(isGreaterThan(0D)).to(DOUBLE_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan(0D)).to(DOUBLE_NEG3, DOUBLE_ZERO).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(false)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThan(0F)).to(FLOAT_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan(0F)).to(FLOAT_NEG3, FLOAT_ZERO).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(false)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThan(0)).to(INT_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan(0)).to(INT_NEG3, INT_ZERO).allMatch(FALSE));
        assertTrue(apply(isGreaterThan((char)0)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThan(0L)).to(LONG_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan(0L)).to(LONG_NEG3, LONG_ZERO).allMatch(FALSE));
        assertTrue(apply(isGreaterThan((char)0)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThan((short)0)).to(SHORT_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan((short)0)).to(SHORT_NEG3, SHORT_ZERO).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(false)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling isGreaterThan(null) throws NPE")
    public void calling_isGreaterThan_w_null_throws_NPE() {
        //noinspection ResultOfMethodCallIgnored
        assertThrows(
            NullPointerException.class,
            () -> isGreaterThan(null)
        );
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(isGreaterThan(0)).to(NUMBER_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThan(0)).to(NUMBER_NULL, NUMBER_NEG3, NUMBER_ZERO).allMatch(FALSE));

        assertTrue(apply(isGreaterThan(OBJECT_VALUE)).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(isAfter("ABC")).to(STRING_XYZ).allMatch(TRUE));
        assertTrue(apply(isAfter("ABC")).to(STRING_NULL, STRING_EMPTY, STRING_ABC).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(isGreaterThan(Collections.emptyList())).to(LIST_NULL, LIST_EMPTY, LIST_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(Collections.emptyMap())).to(MAP_NULL, MAP_EMPTY, MAP_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(Collections.emptySet())).to(SET_NULL, SET_EMPTY, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(isGreaterThan(new Object[] { })).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new boolean[] { })).to(ARRAY_BOOL_NULL, ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new byte[] { })).to(ARRAY_BYTE_NULL, ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new char[] { })).to(ARRAY_CHAR_NULL, ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new double[] { })).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new float[] { })).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new int[] { })).to(ARRAY_INT_NULL, ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new long[] { })).to(ARRAY_LONG_NULL, ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThan(new short[] { })).to(ARRAY_SHORT_NULL, ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns LessThanOrEqualToPredicate")
    public void calling_negate_returns_LessThanOrEqualToPredicate() {
        Predicate<Object> predicate = isGreaterThan(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(LessThanOrEqualToPredicate.class, negated.getClass());
    }
}
