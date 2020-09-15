package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.GreaterThanOrEqualToPredicate.isAfterOrAt;
import static com.snowmantheater.warden.predicate.GreaterThanOrEqualToPredicate.isGreaterThanOrEqualTo;
import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreaterThanOrEqualToPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(isGreaterThanOrEqualTo(true)).to(BOOL_TRUE).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(true)).to(BOOL_FALSE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(false)).to(BOOL_FALSE, BOOL_TRUE).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(0)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(1)).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo((byte)0)).to(BYTE_ZERO, BYTE_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo((byte)0)).to(BYTE_NEG3).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo((char)0)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));

        assertTrue(apply(isAfterOrAt('M')).to(CHAR_M, CHAR_Z).allMatch(TRUE));
        assertTrue(apply(isAfterOrAt('M')).to(CHAR_A).allMatch(FALSE));
        assertTrue(apply(isAfterOrAt(false)).to(CHAR_A, CHAR_M, CHAR_Z).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo(0D)).to(DOUBLE_ZERO, DOUBLE_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(0D)).to(DOUBLE_NEG3).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(false)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo(0F)).to(FLOAT_ZERO, FLOAT_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(0F)).to(FLOAT_NEG3).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(false)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo(0)).to(INT_ZERO, INT_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(0)).to(INT_NEG3).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo((char)0)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo(0L)).to(LONG_ZERO, LONG_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(0L)).to(LONG_NEG3).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo((char)0)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo((short)0)).to(SHORT_ZERO, SHORT_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo((short)0)).to(SHORT_NEG3).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(false)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling isGreaterThanOrEqualTo(null) throws NPE")
    public void calling_isGreaterThanOrEqualTo_w_null_throws_NPE() {
        assertThrows(
            NullPointerException.class,
            () -> new GreaterThanOrEqualToPredicate(null)
        );
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(isGreaterThanOrEqualTo(0)).to(NUMBER_ZERO, NUMBER_POS3).allMatch(TRUE));
        assertTrue(apply(isGreaterThanOrEqualTo(0)).to(NUMBER_NULL, NUMBER_NEG3).allMatch(FALSE));

        assertTrue(apply(isGreaterThanOrEqualTo(OBJECT_VALUE)).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(isAfterOrAt("ABC")).to(STRING_ABC, STRING_XYZ).allMatch(TRUE));
        assertTrue(apply(isAfterOrAt("ABC")).to(STRING_NULL, STRING_EMPTY).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(isGreaterThanOrEqualTo(Collections.emptyList())).to(LIST_NULL, LIST_EMPTY, LIST_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(Collections.emptyMap())).to(MAP_NULL, MAP_EMPTY, MAP_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(Collections.emptySet())).to(SET_NULL, SET_EMPTY, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(isGreaterThanOrEqualTo(new Object[] { })).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new boolean[] { })).to(ARRAY_BOOL_NULL, ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new byte[] { })).to(ARRAY_BYTE_NULL, ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new char[] { })).to(ARRAY_CHAR_NULL, ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new double[] { })).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new float[] { })).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new int[] { })).to(ARRAY_INT_NULL, ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new long[] { })).to(ARRAY_LONG_NULL, ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(FALSE));
        assertTrue(apply(isGreaterThanOrEqualTo(new short[] { })).to(ARRAY_SHORT_NULL, ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns LessThanPredicate")
    public void calling_negate_returns_LessThanPredicate() {
        Predicate<Object> predicate = isGreaterThanOrEqualTo(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(LessThanPredicate.class, negated.getClass());
    }
}
