package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.EqualToPredicate.isEqualTo;
import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EqualToPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(isEqualTo(true)).to(BOOL_TRUE).allMatch(TRUE));
        assertTrue(apply(isEqualTo(true)).to(BOOL_FALSE).allMatch(FALSE));
        assertTrue(apply(isEqualTo(0L)).to(BOOL_TRUE, BOOL_FALSE).allMatch(FALSE));

        assertTrue(apply(isEqualTo((byte)3)).to(BYTE_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo((byte)3)).to(BYTE_NEG3, BYTE_ZERO).allMatch(FALSE));
        assertTrue(apply(isEqualTo((char)3)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));

        assertTrue(apply(isEqualTo('Z')).to(CHAR_Z).allMatch(TRUE));
        assertTrue(apply(isEqualTo('Z')).to(CHAR_0, CHAR_A).allMatch(FALSE));
        assertTrue(apply(isEqualTo(false)).to(CHAR_0, CHAR_A, CHAR_Z).allMatch(FALSE));

        assertTrue(apply(isEqualTo(3.3D)).to(DOUBLE_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo(3.3D)).to(DOUBLE_NEG3, DOUBLE_ZERO).allMatch(FALSE));
        assertTrue(apply(isEqualTo(false)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));

        assertTrue(apply(isEqualTo(3.3F)).to(FLOAT_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo(3.3F)).to(FLOAT_NEG3, FLOAT_ZERO).allMatch(FALSE));
        assertTrue(apply(isEqualTo(false)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));

        assertTrue(apply(isEqualTo(3)).to(INT_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo(3)).to(INT_NEG3, INT_ZERO).allMatch(FALSE));
        assertTrue(apply(isEqualTo((char)3)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));

        assertTrue(apply(isEqualTo(3L)).to(LONG_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo(3L)).to(LONG_NEG3, LONG_ZERO).allMatch(FALSE));
        assertTrue(apply(isEqualTo((char)3)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));

        assertTrue(apply(isEqualTo((short)3)).to(SHORT_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo((short)3)).to(SHORT_NEG3, SHORT_ZERO).allMatch(FALSE));
        assertTrue(apply(isEqualTo(false)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(isEqualTo(null)).to(NUMBER_NULL).allMatch(TRUE));
        assertTrue(apply(isEqualTo(null)).to(NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));
        assertTrue(apply(isEqualTo(3)).to(NUMBER_POS3).allMatch(TRUE));
        assertTrue(apply(isEqualTo(3)).to(NUMBER_NULL, NUMBER_NEG3, NUMBER_ZERO).allMatch(FALSE));

        assertTrue(apply(isEqualTo(null)).to(OBJECT_NULL).allMatch(TRUE));
        assertTrue(apply(isEqualTo(null)).to(OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(isEqualTo(OBJECT_VALUE)).to(OBJECT_VALUE).allMatch(TRUE));
        assertTrue(apply(isEqualTo(OBJECT_VALUE)).to(OBJECT_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(isEqualTo(null)).to(STRING_NULL).allMatch(TRUE));
        assertTrue(apply(isEqualTo(null)).to(STRING_EMPTY, STRING_ABC, STRING_XYZ).allMatch(FALSE));
        assertTrue(apply(isEqualTo("ABC")).to(STRING_ABC).allMatch(TRUE));
        assertTrue(apply(isEqualTo("ABC")).to(STRING_NULL, STRING_EMPTY, STRING_XYZ).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(isEqualTo(Collections.emptyList())).to(LIST_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(Collections.emptyList())).to(LIST_NULL, LIST_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(Collections.emptyMap())).to(MAP_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(Collections.emptyMap())).to(MAP_NULL, MAP_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(Collections.emptySet())).to(SET_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(Collections.emptySet())).to(SET_NULL, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(isEqualTo(new Object[] { })).toOne(ARRAY_OBJECT_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new Object[] { })).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new boolean[] { })).toOne(ARRAY_BOOL_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new boolean[] { })).to(ARRAY_BOOL_NULL, ARRAY_BOOL_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new byte[] {1, 2, 3})).toOne(ARRAY_BYTE_VALUE).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new byte[] {1, 2, 3})).to(ARRAY_BYTE_NULL, ARRAY_BYTE_EMPTY).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new char[] {'A', 'B', 'C'})).toOne(ARRAY_CHAR_VALUE).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new char[] {'A', 'B', 'C'})).to(ARRAY_CHAR_NULL, ARRAY_CHAR_EMPTY).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new double[] { })).toOne(ARRAY_DOUBLE_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new double[] { })).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new float[] { })).toOne(ARRAY_FLOAT_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new float[] { })).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new int[] { })).toOne(ARRAY_INT_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new int[] { })).to(ARRAY_INT_NULL, ARRAY_INT_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new long[] { })).toOne(ARRAY_LONG_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new long[] { })).to(ARRAY_LONG_NULL, ARRAY_LONG_VALUE).allMatch(FALSE));

        assertTrue(apply(isEqualTo(new short[] { })).toOne(ARRAY_SHORT_EMPTY).allMatch(TRUE));
        assertTrue(apply(isEqualTo(new short[] { })).to(ARRAY_SHORT_NULL, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns NotEqualToPredicate")
    public void calling_negate_returns_NotEqualToPredicate() {
        Predicate<Object> predicate = isEqualTo(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(NotEqualToPredicate.class, negated.getClass());
    }
}
