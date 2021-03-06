package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmptyPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(new EmptyPredicate()).to(BOOL_FALSE, BOOL_TRUE).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(CHAR_0, CHAR_A, CHAR_Z).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(apply(new EmptyPredicate()).to(NUMBER_NULL, NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));
        assertTrue(apply(new EmptyPredicate()).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(new EmptyPredicate()).to(STRING_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(STRING_NULL, STRING_ABC, STRING_XYZ).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(new EmptyPredicate()).to(LIST_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(LIST_NULL, LIST_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).to(MAP_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(MAP_NULL, MAP_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).to(SET_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(SET_NULL, SET_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_OBJECT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_BOOL_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_BOOL_NULL, ARRAY_BOOL_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_BYTE_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_BYTE_NULL, ARRAY_BYTE_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_CHAR_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_CHAR_NULL, ARRAY_CHAR_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_DOUBLE_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_FLOAT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_INT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_INT_NULL, ARRAY_INT_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_LONG_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_LONG_NULL, ARRAY_LONG_VALUE).allMatch(FALSE));

        assertTrue(apply(new EmptyPredicate()).toOne(ARRAY_SHORT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new EmptyPredicate()).to(ARRAY_SHORT_NULL, ARRAY_SHORT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns NotEmptyPredicate")
    public void calling_negate_returns_instanceof_NotEmptyPredicate() {
        Predicate<Object> predicate = new EmptyPredicate();
        Predicate<Object> negated = predicate.negate();
        assertEquals(NotEmptyPredicate.class, negated.getClass());
    }
}
