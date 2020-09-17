package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotEmptyPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(new NotEmptyPredicate()).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(CHAR_0, CHAR_A, CHAR_Z).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(new NotEmptyPredicate()).to(NUMBER_NULL, NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));
        assertTrue(apply(new NotEmptyPredicate()).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(new NotEmptyPredicate()).to(STRING_ABC, STRING_XYZ).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(STRING_NULL, STRING_EMPTY).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(new NotEmptyPredicate()).to(LIST_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(LIST_NULL, LIST_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).to(MAP_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(MAP_NULL, MAP_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).to(SET_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(SET_NULL, SET_EMPTY).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_OBJECT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_BOOL_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_BOOL_NULL, ARRAY_BOOL_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_BYTE_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_BYTE_NULL, ARRAY_BYTE_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_CHAR_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_CHAR_NULL, ARRAY_CHAR_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_DOUBLE_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_FLOAT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_INT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_INT_NULL, ARRAY_INT_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_LONG_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_LONG_NULL, ARRAY_LONG_EMPTY).allMatch(FALSE));

        assertTrue(apply(new NotEmptyPredicate()).toOne(ARRAY_SHORT_VALUE).allMatch(TRUE));
        assertTrue(apply(new NotEmptyPredicate()).to(ARRAY_SHORT_NULL, ARRAY_SHORT_EMPTY).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns NotEmptyPredicate")
    public void calling_negate_returns_NotEmptyPredicate() {
        Predicate<Object> predicate = new NotEmptyPredicate();
        Predicate<Object> negated = predicate.negate();
        assertEquals(EmptyPredicate.class, negated.getClass());
    }
}
