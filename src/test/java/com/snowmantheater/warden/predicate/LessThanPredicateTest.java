package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LessThanPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(new LessThanPredicate(true)).to(BOOL_FALSE).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate(false)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(0)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(1)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate((byte)0)).to(BYTE_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate((byte)0)).to(BYTE_ZERO, BYTE_POS3).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate((char)0)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate('M')).to(CHAR_A).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate('M')).to(CHAR_M, CHAR_Z).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(false)).to(CHAR_A, CHAR_M, CHAR_Z).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate(0D)).to(DOUBLE_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate(0D)).to(DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(false)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate(0F)).to(FLOAT_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate(0F)).to(FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(false)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate(0)).to(INT_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate(0)).to(INT_ZERO, INT_POS3).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate((char)0)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate(0L)).to(LONG_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate(0L)).to(LONG_ZERO, LONG_POS3).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate((char)0)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate((short)0)).to(SHORT_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate((short)0)).to(SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(false)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling isnew LessThanPredicate(null) throws NPE")
    public void calling_isLessThan_w_null_throws_NPE() {
        assertThrows(
            NullPointerException.class,
            () -> new LessThanPredicate(null)
        );
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(new LessThanPredicate(0)).to(NUMBER_NEG3).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate(0)).to(NUMBER_NULL, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));

        assertTrue(apply(new LessThanPredicate(OBJECT_VALUE)).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(new LessThanPredicate("ABC")).to(STRING_EMPTY).allMatch(TRUE));
        assertTrue(apply(new LessThanPredicate("ABC")).to(STRING_NULL, STRING_ABC, STRING_XYZ).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(new LessThanPredicate(Collections.emptyList())).to(LIST_NULL, LIST_EMPTY, LIST_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(Collections.emptyMap())).to(MAP_NULL, MAP_EMPTY, MAP_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(Collections.emptySet())).to(SET_NULL, SET_EMPTY, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(new LessThanPredicate(new Object[] { })).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new boolean[] { })).to(ARRAY_BOOL_NULL, ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new byte[] { })).to(ARRAY_BYTE_NULL, ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new char[] { })).to(ARRAY_CHAR_NULL, ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new double[] { })).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new float[] { })).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new int[] { })).to(ARRAY_INT_NULL, ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new long[] { })).to(ARRAY_LONG_NULL, ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(FALSE));
        assertTrue(apply(new LessThanPredicate(new short[] { })).to(ARRAY_SHORT_NULL, ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns GreaterThanOrEqualToPredicate")
    public void calling_negate_returns_GreaterThanOrEqualToPredicate() {
        Predicate<Object> predicate = new LessThanPredicate(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(GreaterThanOrEqualToPredicate.class, negated.getClass());
    }
}
