package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    @Test
    @DisplayName("Calling when(null) returns ValueValidator")
    public void calling_when_w_null_returns_ValueValidator() {
        Validator validator = Validator.when(null);
        assertEquals(validator.getClass(), ValueValidator.class);
    }

    @Test
    @DisplayName("Calling when(1) returns ValueValidator")
    public void calling_when_w_1_returns_ValueValidator() {
        Validator validator = Validator.when(1);
        assertEquals(validator.getClass(), ValueValidator.class);
    }

    @Test
    @DisplayName("Calling when(\"A\") returns ValueValidator")
    public void calling_when_w_A_returns_ValueValidator() {
        Validator validator = Validator.when("A");
        assertEquals(validator.getClass(), ValueValidator.class);
    }

    @Test
    @DisplayName("Calling when(null, null) throws NPE")
    public void calling_when_w_null_and_null_throws_NPE() {
        assertThrows(NullPointerException.class, () -> Validator.when(null, null));
    }

    @Test
    @DisplayName("Calling when(null, 1) throws NPE")
    public void calling_when_w_null_and_1_throws_NPE() {
        assertThrows(NullPointerException.class, () -> Validator.when(null, 1));
    }

    @Test
    @DisplayName("Calling when(null, \"A\") throws NPE")
    public void calling_when_w_null_and_A_throws_NPE() {
        assertThrows(NullPointerException.class, () -> Validator.when(null, "A"));
    }

    @Test
    @DisplayName("Calling when(\"name\", null) returns FieldValidator")
    public void calling_when_w_name_and_null_returns_FieldValidator() {
        Validator validator = Validator.when("name", null);
        assertEquals(validator.getClass(), FieldValidator.class);
    }

    @Test
    @DisplayName("Calling when(\"name\", 1) returns FieldValidator")
    public void calling_when_w_name_and_1_returns_FieldValidator() {
        Validator validator = Validator.when("name", 1);
        assertEquals(validator.getClass(), FieldValidator.class);
    }

    @Test
    @DisplayName("Calling when(\"name\", \"A\") returns FieldValidator")
    public void calling_when_w_name_and_A_returns_FieldValidator() {
        Validator validator = Validator.when("name", "A");
        assertEquals(validator.getClass(), FieldValidator.class);
    }
}