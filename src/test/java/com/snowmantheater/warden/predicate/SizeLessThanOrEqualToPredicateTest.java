package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.snowmantheater.warden.predicate.PredicateTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SizeLessThanOrEqualToPredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(BOOL_TRUE, BOOL_FALSE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(BOOL_TRUE, BOOL_FALSE).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(BYTE_NEG3, BYTE_ZERO, BYTE_POS3).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(CHAR_0, CHAR_A, CHAR_M, CHAR_Z).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(CHAR_0, CHAR_A, CHAR_M, CHAR_Z).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(DOUBLE_NEG3, DOUBLE_ZERO, DOUBLE_POS3).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(FLOAT_NEG3, FLOAT_ZERO, FLOAT_POS3).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(INT_NEG3, INT_ZERO, INT_POS3).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(LONG_NEG3, LONG_ZERO, LONG_POS3).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(SHORT_NEG3, SHORT_ZERO, SHORT_POS3).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        assertTrue(
            apply(new SizeLessThanOrEqualToPredicate(0)).to(NUMBER_NULL, NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));
        assertTrue(
            apply(new SizeLessThanOrEqualToPredicate(1)).to(NUMBER_NULL, NUMBER_NEG3, NUMBER_ZERO, NUMBER_POS3).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(1)).to(OBJECT_NULL, OBJECT_VALUE).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(STRING_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(STRING_NULL, STRING_ABC, STRING_XYZ).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(STRING_EMPTY, STRING_ABC, STRING_XYZ).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(STRING_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(LIST_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(LIST_NULL, LIST_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(LIST_EMPTY, LIST_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(LIST_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(MAP_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(MAP_NULL, MAP_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(MAP_EMPTY, MAP_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(MAP_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(SET_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(SET_NULL, SET_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(SET_EMPTY, SET_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(SET_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_OBJECT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_OBJECT_NULL, ARRAY_OBJECT_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_OBJECT_EMPTY, ARRAY_OBJECT_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_OBJECT_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_BOOL_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_BOOL_NULL, ARRAY_BOOL_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_BOOL_EMPTY, ARRAY_BOOL_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_BOOL_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_BYTE_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_BYTE_NULL, ARRAY_BYTE_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_BYTE_EMPTY, ARRAY_BYTE_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_BYTE_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_CHAR_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_CHAR_NULL, ARRAY_CHAR_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_CHAR_EMPTY, ARRAY_CHAR_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_CHAR_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_DOUBLE_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_DOUBLE_NULL, ARRAY_DOUBLE_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_DOUBLE_EMPTY, ARRAY_DOUBLE_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_DOUBLE_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_FLOAT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_FLOAT_NULL, ARRAY_FLOAT_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_FLOAT_EMPTY, ARRAY_FLOAT_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_FLOAT_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_INT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_INT_NULL, ARRAY_INT_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_INT_EMPTY, ARRAY_INT_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_INT_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_LONG_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_LONG_NULL, ARRAY_LONG_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_LONG_EMPTY, ARRAY_LONG_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_LONG_NULL).allMatch(FALSE));

        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).toOne(ARRAY_SHORT_EMPTY).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(0)).to(ARRAY_SHORT_NULL, ARRAY_SHORT_VALUE).allMatch(FALSE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).to(ARRAY_SHORT_EMPTY, ARRAY_SHORT_VALUE).allMatch(TRUE));
        assertTrue(apply(new SizeLessThanOrEqualToPredicate(3)).toOne(ARRAY_SHORT_NULL).allMatch(FALSE));
    }

    @Test
    @DisplayName("Calling negate() returns SizeGreaterThanPredicate")
    public void calling_negate_returns_SizeGreaterThanPredicate() {
        Predicate<Object> predicate = new SizeLessThanOrEqualToPredicate(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(SizeGreaterThanPredicate.class, negated.getClass());
    }
}
