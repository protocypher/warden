package com.snowmantheater.warden.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotEqualToPredicateTest extends PredicateTest {
    @Test
    @DisplayName("Calling test(primitive) ...")
    public void calling_test_w_primitive_() {
        Predicate<Object> predicate;

        predicate = new NotEqualToPredicate(true);
        assertFalse(predicate.test(BOOL_TRUE));
        assertTrue(predicate.test(BOOL_FALSE));

        predicate = new NotEqualToPredicate(0L);
        assertTrue(predicate.test(BOOL_TRUE));
        assertTrue(predicate.test(BOOL_FALSE));

        predicate = new NotEqualToPredicate((byte)3);
        assertTrue(predicate.test(BYTE_NEG3));
        assertTrue(predicate.test(BYTE_ZERO));
        assertFalse(predicate.test(BYTE_POS3));

        predicate = new NotEqualToPredicate((char)3);
        assertTrue(predicate.test(BYTE_NEG3));
        assertTrue(predicate.test(BYTE_ZERO));
        assertTrue(predicate.test(BYTE_POS3));

        predicate = new NotEqualToPredicate('Z');
        assertTrue(predicate.test(CHAR_0));
        assertTrue(predicate.test(CHAR_A));
        assertFalse(predicate.test(CHAR_Z));

        predicate = new NotEqualToPredicate(false);
        assertTrue(predicate.test(CHAR_0));
        assertTrue(predicate.test(CHAR_A));
        assertTrue(predicate.test(CHAR_Z));

        predicate = new NotEqualToPredicate(3.3D);
        assertTrue(predicate.test(DOUBLE_NEG3));
        assertTrue(predicate.test(DOUBLE_ZERO));
        assertFalse(predicate.test(DOUBLE_POS3));

        predicate = new NotEqualToPredicate(false);
        assertTrue(predicate.test(DOUBLE_NEG3));
        assertTrue(predicate.test(DOUBLE_ZERO));
        assertTrue(predicate.test(DOUBLE_POS3));

        predicate = new NotEqualToPredicate(3.3F);
        assertTrue(predicate.test(FLOAT_NEG3));
        assertTrue(predicate.test(FLOAT_ZERO));
        assertFalse(predicate.test(FLOAT_POS3));

        predicate = new NotEqualToPredicate(false);
        assertTrue(predicate.test(FLOAT_NEG3));
        assertTrue(predicate.test(FLOAT_ZERO));
        assertTrue(predicate.test(FLOAT_POS3));

        predicate = new NotEqualToPredicate(3);
        assertTrue(predicate.test(INT_NEG3));
        assertTrue(predicate.test(INT_ZERO));
        assertFalse(predicate.test(INT_POS3));

        predicate = new NotEqualToPredicate((char)3);
        assertTrue(predicate.test(INT_NEG3));
        assertTrue(predicate.test(INT_ZERO));
        assertTrue(predicate.test(INT_POS3));

        predicate = new NotEqualToPredicate(3L);
        assertTrue(predicate.test(LONG_NEG3));
        assertTrue(predicate.test(LONG_ZERO));
        assertFalse(predicate.test(LONG_POS3));

        predicate = new NotEqualToPredicate((char)3);
        assertTrue(predicate.test(LONG_NEG3));
        assertTrue(predicate.test(LONG_ZERO));
        assertTrue(predicate.test(LONG_POS3));

        predicate = new NotEqualToPredicate((short)3);
        assertTrue(predicate.test(SHORT_NEG3));
        assertTrue(predicate.test(SHORT_ZERO));
        assertFalse(predicate.test(SHORT_POS3));

        predicate = new NotEqualToPredicate(false);
        assertTrue(predicate.test(SHORT_NEG3));
        assertTrue(predicate.test(SHORT_ZERO));
        assertTrue(predicate.test(SHORT_POS3));
    }

    @Test
    @DisplayName("Calling test(instance) ...")
    public void calling_test_w_instance_() {
        Predicate<Object> predicate;

        predicate = new NotEqualToPredicate(null);
        assertFalse(predicate.test(NUMBER_NULL));
        assertTrue(predicate.test(NUMBER_NEG3));
        assertTrue(predicate.test(NUMBER_ZERO));
        assertTrue(predicate.test(NUMBER_POS3));

        predicate = new NotEqualToPredicate(3);
        assertTrue(predicate.test(NUMBER_NULL));
        assertTrue(predicate.test(NUMBER_NEG3));
        assertTrue(predicate.test(NUMBER_ZERO));
        assertFalse(predicate.test(NUMBER_POS3));

        predicate = new NotEqualToPredicate(null);
        assertFalse(predicate.test(OBJECT_NULL));
        assertTrue(predicate.test(OBJECT_VALUE));

        predicate = new NotEqualToPredicate(OBJECT_VALUE);
        assertTrue(predicate.test(OBJECT_NULL));
        assertFalse(predicate.test(OBJECT_VALUE));
    }

    @Test
    @DisplayName("Calling test(String) ...")
    public void calling_test_w_String_() {
        Predicate<Object> predicate;

        predicate = new NotEqualToPredicate(null);
        assertFalse(predicate.test(STRING_NULL));
        assertTrue(predicate.test(STRING_EMPTY));
        assertTrue(predicate.test(STRING_ABC));
        assertTrue(predicate.test(STRING_XYZ));

        predicate = new NotEqualToPredicate("ABC");
        assertTrue(predicate.test(STRING_NULL));
        assertTrue(predicate.test(STRING_EMPTY));
        assertFalse(predicate.test(STRING_ABC));
        assertTrue(predicate.test(STRING_XYZ));
    }

    @Test
    @DisplayName("Calling test(Collection) ...")
    public void calling_test_w_Collection_() {
        Predicate<Object> predicate;

        predicate = new NotEqualToPredicate(Collections.emptyList());
        assertTrue(predicate.test(LIST_NULL));
        assertFalse(predicate.test(LIST_EMPTY));
        assertTrue(predicate.test(LIST_VALUE));

        predicate = new NotEqualToPredicate(Collections.emptyMap());
        assertTrue(predicate.test(MAP_NULL));
        assertFalse(predicate.test(MAP_EMPTY));
        assertTrue(predicate.test(MAP_VALUE));

        predicate = new NotEqualToPredicate(Collections.emptySet());
        assertTrue(predicate.test(SET_NULL));
        assertFalse(predicate.test(SET_EMPTY));
        assertTrue(predicate.test(SET_VALUE));
    }

    @Test
    @DisplayName("Calling test(array) ...")
    public void calling_test_w_array_() {
        Predicate<Object> predicate;

        predicate = new NotEqualToPredicate(new Object[] { });
        assertTrue(predicate.test(ARRAY_OBJECT_NULL));
        assertFalse(predicate.test(ARRAY_OBJECT_EMPTY));
        assertTrue(predicate.test(ARRAY_OBJECT_VALUE));

        predicate = new NotEqualToPredicate(new boolean[] { });
        assertTrue(predicate.test(ARRAY_BOOL_NULL));
        assertFalse(predicate.test(ARRAY_BOOL_EMPTY));
        assertTrue(predicate.test(ARRAY_BOOL_VALUE));

        predicate = new NotEqualToPredicate(new byte[] {1, 2, 3});
        assertTrue(predicate.test(ARRAY_BYTE_NULL));
        assertTrue(predicate.test(ARRAY_BYTE_EMPTY));
        assertFalse(predicate.test(ARRAY_BYTE_VALUE));

        predicate = new NotEqualToPredicate(new char[] {'A', 'B', 'C'});
        assertTrue(predicate.test(ARRAY_CHAR_NULL));
        assertTrue(predicate.test(ARRAY_CHAR_EMPTY));
        assertFalse(predicate.test(ARRAY_CHAR_VALUE));

        predicate = new NotEqualToPredicate(new double[] { });
        assertTrue(predicate.test(ARRAY_DOUBLE_NULL));
        assertFalse(predicate.test(ARRAY_DOUBLE_EMPTY));
        assertTrue(predicate.test(ARRAY_DOUBLE_VALUE));

        predicate = new NotEqualToPredicate(new float[] { });
        assertTrue(predicate.test(ARRAY_FLOAT_NULL));
        assertFalse(predicate.test(ARRAY_FLOAT_EMPTY));
        assertTrue(predicate.test(ARRAY_FLOAT_VALUE));

        predicate = new NotEqualToPredicate(new int[] { });
        assertTrue(predicate.test(ARRAY_INT_NULL));
        assertFalse(predicate.test(ARRAY_INT_EMPTY));
        assertTrue(predicate.test(ARRAY_INT_VALUE));

        predicate = new NotEqualToPredicate(new long[] { });
        assertTrue(predicate.test(ARRAY_LONG_NULL));
        assertFalse(predicate.test(ARRAY_LONG_EMPTY));
        assertTrue(predicate.test(ARRAY_LONG_VALUE));

        predicate = new NotEqualToPredicate(new short[] { });
        assertTrue(predicate.test(ARRAY_SHORT_NULL));
        assertFalse(predicate.test(ARRAY_SHORT_EMPTY));
        assertTrue(predicate.test(ARRAY_SHORT_VALUE));
    }

    @Test
    @DisplayName("Calling negate() returns EqualToPredicate")
    public void calling_negate_returns_EqualToPredicate() {
        Predicate<Object> predicate = new NotEqualToPredicate(0);
        Predicate<Object> negated = predicate.negate();
        assertEquals(EqualToPredicate.class, negated.getClass());
    }
}
