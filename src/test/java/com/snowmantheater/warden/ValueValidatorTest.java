package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueValidatorTest {
    @Test
    @DisplayName("Given value=null, calling getValue() returns null")
    public void given_value_is_null_calling_getValue_returns_null() {
        ValueValidator validator = new ValueValidator(null);
        assertNull(validator.getValue());
    }

    @Test
    @DisplayName("Given value=3, calling getValue() returns 3")
    public void given_value_is_3_calling_getValue_returns_3() {
        ValueValidator validator = new ValueValidator(3);
        assertEquals(3, validator.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling getValue() returns \"A\"")
    public void given_value_is_A_calling_getValue_returns_A() {
        ValueValidator validator = new ValueValidator("A");
        assertEquals("A", validator.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling is(Predicate{true}) returns ValidatorActions(matching=true, value=value)")
    public void given_value_is_A_calling_is_Predicate_true_returns_Actions_matching_is_true() {
        ValueValidator validator = new ValueValidator("A");
        ValidatorActions actions = validator.is(t -> true);
        assertTrue(actions.isMatching());
        assertEquals("A", actions.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling is(Predicate{false}) returns ValidatorActions(matching=false, value=value)")
    public void given_value_is_A_calling_is_Predicate_false_returns_Actions_matching_is_false() {
        ValueValidator validator = new ValueValidator("A");
        ValidatorActions actions = validator.is(t -> false);
        assertFalse(actions.isMatching());
        assertEquals("A", actions.getValue());
    }
}
