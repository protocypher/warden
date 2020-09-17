package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotNullPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(new NotNullPredicate()).to(BOOL_FALSE, BOOL_TRUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(CHAR_0, CHAR_A, CHAR_Z).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(TRUE));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(new NotNullPredicate()).to(NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(NUMBER_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(OBJECT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(OBJECT_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(new NotNullPredicate()).to(STRING_EMPTY, STRING_ABC, STRING_XYZ).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(STRING_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(new NotNullPredicate()).to(LIST_EMPTY, LIST_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(LIST_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(MAP_EMPTY, MAP_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(MAP_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(SET_EMPTY, SET_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).to(SET_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(new NotNullPredicate()).to(ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_OBJECT_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_BOOL_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_BYTE_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_CHAR_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_DOUBLE_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_FLOAT_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_INT_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_LONG_NULL).allMatch(FALSE));

        assertTrue(apply(new NotNullPredicate()).to(ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotNullPredicate()).toOne(ARRAY_SHORT_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns NullPredicate")
    public void calling_negate_returns_NullPredicate() {
        Predicate<Object> predicate = new NotNullPredicate();
        Predicate<Object> negated = predicate.negate();
        assertEquals(NullPredicate.class, negated.getClass());
    }
}
