package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableValidatorTest {
    @Test
    @DisplayName("Given name=null, calling new throws IllegalArgumentException")
    public void given_name_is_null_calling_new_throws_IAE() {
        assertThrows(IllegalArgumentException.class, () -> new VariableValidator(null, null));
    }

    @Test
    @DisplayName("Given name=\"n\", calling getName() returns \"n\"")
    public void given_name_is_n_calling_getName_returns_n() {
        VariableValidator validator = new VariableValidator("n", null);
        assertEquals("n", validator.getName());
    }

    @Test
    @DisplayName("Given value=null, calling getValue() returns null")
    public void given_value_is_null_calling_getValue_returns_null() {
        VariableValidator validator = new VariableValidator("n", null);
        assertNull(validator.getValue());
    }

    @Test
    @DisplayName("Given value=3, calling getValue() returns 3")
    public void given_value_is_3_calling_getValue_returns_3() {
        VariableValidator validator = new VariableValidator("n", 3);
        assertEquals(3, validator.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling getValue() returns \"A\"")
    public void given_value_is_A_calling_getValue_returns_A() {
        VariableValidator validator = new VariableValidator("n", "A");
        assertEquals("A", validator.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling is(Predicate{true}) returns ValidatorActions(matching=true, value=value)")
    public void given_value_is_A_calling_is_Predicate_true_returns_Actions_matching_is_true() {
        VariableValidator validator = new VariableValidator("n", "A");
        ValidatorActions actions = validator.is(t -> true);
        assertTrue(actions.isMatching());
        assertEquals("A", actions.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling is(Predicate{false}) returns ValidatorActions(matching=false, value=value)")
    public void given_value_is_A_calling_is_Predicate_false_returns_Actions_matching_is_false() {
        VariableValidator validator = new VariableValidator("n", "A");
        ValidatorActions actions = validator.is(t -> false);
        assertFalse(actions.isMatching());
        assertEquals("A", actions.getValue());
    }
}
