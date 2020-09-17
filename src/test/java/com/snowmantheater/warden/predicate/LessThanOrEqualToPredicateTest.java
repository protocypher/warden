package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.LessThanOrEqualToPredicate.BeforeOrAt;
import static com.snowmantheater.warden.predicate.LessThanOrEqualToPredicate.LessThanOrEqualTo;
import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LessThanOrEqualToPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(LessThanOrEqualTo(true)).to(BOOL_FALSE, BOOL_TRUE).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(false)).to(BOOL_FALSE).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(false)).to(BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(0)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(1)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo((byte)0)).to(BYTE_NEG3, BYTE_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo((byte)0)).to(BYTE_POS3).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo((char)0)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));

        assertTrue(apply(BeforeOrAt('M')).to(CHAR_A, CHAR_M).allMatch(TRUE));
        assertTrue(apply(BeforeOrAt('M')).to(CHAR_Z).allMatch(FALSE));
        assertTrue(apply(BeforeOrAt(false)).to(CHAR_A, CHAR_M, CHAR_Z).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo(0D)).to(DOUBLE_NEG3, DOUBLE_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(0D)).to(DOUBLE_POS3).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(false)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo(0F)).to(FLOAT_NEG3, FLOAT_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(0F)).to(FLOAT_POS3).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(false)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo(0)).to(INT_NEG3, INT_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(0)).to(INT_POS3).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo((char)0)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo(0L)).to(LONG_NEG3, LONG_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(0L)).to(LONG_POS3).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo((char)0)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo((short)0)).to(SHORT_NEG3, SHORT_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo((short)0)).to(SHORT_POS3).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(false)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling isLessThanOrEqualTo(null) throws NPE")
    public void calling_isLessTHanOrEqualTo_w_null_throws_NPE() {
        //noinspection ResultOfMethodCallIgnored
        assertThrows(
            NullPointerException.class,
            () -> LessThanOrEqualTo(null)
        );
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(LessThanOrEqualTo(0)).to(NUMBER_NEG3, NUMBER_ZERO).allMatch(TRUE));
        assertTrue(apply(LessThanOrEqualTo(0)).to(NUMBER_NULL, NUMBER_POS3).allMatch(FALSE));

        assertTrue(apply(LessThanOrEqualTo(OBJECT_VALUE)).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(BeforeOrAt("ABC")).to(STRING_EMPTY, STRING_ABC).allMatch(TRUE));
        assertTrue(apply(BeforeOrAt("ABC")).to(STRING_NULL, STRING_XYZ).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(LessThanOrEqualTo(Collections.emptyList())).to(LIST_NULL, LIST_EMPTY, LIST_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(Collections.emptyMap())).to(MAP_NULL, MAP_EMPTY, MAP_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(Collections.emptySet())).to(SET_NULL, SET_EMPTY, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(LessThanOrEqualTo(new Object[] { })).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new boolean[] { })).to(ARRAY_BOOL_NULL, ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new byte[] { })).to(ARRAY_BYTE_NULL, ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new char[] { })).to(ARRAY_CHAR_NULL, ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new double[] { })).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new float[] { })).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new int[] { })).to(ARRAY_INT_NULL, ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new long[] { })).to(ARRAY_LONG_NULL, ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(FALSE));
        assertTrue(apply(LessThanOrEqualTo(new short[] { })).to(ARRAY_SHORT_NULL, ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns GreaterThanPredicate")
    public void calling_negate_returns_GreaterThanPredicate() {
        Predicate<Object> predicate = LessThanOrEqualTo(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(GreaterThanPredicate.class, negated.getClass());
    }
}
