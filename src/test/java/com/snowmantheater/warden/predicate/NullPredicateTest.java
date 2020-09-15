package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.NullPredicate.isNull;
import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NullPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(isNull()).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(isNull()).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));
        assertTrue(apply(isNull()).to(CHAR_0, CHAR_A, CHAR_Z).allMatch(FALSE));
        assertTrue(apply(isNull()).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));
        assertTrue(apply(isNull()).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));
        assertTrue(apply(isNull()).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));
        assertTrue(apply(isNull()).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));
        assertTrue(apply(isNull()).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(isNull()).to(NUMBER_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));

        assertTrue(apply(isNull()).to(OBJECT_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(isNull()).to(STRING_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(STRING_EMPTY, STRING_ABC, STRING_XYZ).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(isNull()).to(LIST_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(LIST_EMPTY, LIST_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).to(MAP_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(MAP_EMPTY, MAP_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).to(SET_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(SET_EMPTY, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(isNull()).toOne(ARRAY_OBJECT_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_BOOL_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_BYTE_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_CHAR_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_DOUBLE_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_FLOAT_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_INT_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_LONG_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(FALSE));

        assertTrue(apply(isNull()).toOne(ARRAY_SHORT_NULL).allMatch(TRUE));
        assertTrue(apply(isNull()).to(ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns NotNullPredicate")
    public void calling_negate_returns_NotNullPredicate() {
        Predicate<Object> predicate = isNull();
        Predicate<Object> negated = predicate.negate();
        assertEquals(NotNullPredicate.class, negated.getClass());
    }
}
