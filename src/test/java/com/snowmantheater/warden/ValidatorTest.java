package com.snowmantheater.warden;

import org.junit.jupiter.api.Test;

import static com.snowmantheater.warden.Validator.when;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void test_when_X() {
        Validator validator;

        validator = when(null);
        assertNotNull(validator);

        validator = when("A");
        assertNotNull(validator);

        validator = when(1);
        assertNotNull(validator);
    }

    @Test
    void test_when_X_X() {
        Validator validator;
        String name = "name";

        assertThrows(NullPointerException.class, () -> when(null, null));

        validator = when(name, null);
        assertNotNull(validator);

        validator = when(name, "A");
        assertNotNull(validator);

        validator = when(name, 1);
        assertNotNull(validator);
    }

    @Test
    void test_when_X_X_X() {
        Validator validator;
        String name = "name";
        Object parent = new Object();

        assertThrows(NullPointerException.class, () -> when(null, null, null));
        assertThrows(NullPointerException.class, () -> when(null, name, null));
        assertThrows(NullPointerException.class, () -> when(parent, null, null));

        validator = when(parent, name, null);
        assertNotNull(validator);

        validator = when(parent, name, "A");
        assertNotNull(validator);

        validator = when(parent, name, 1);
        assertNotNull(validator);
    }

    @Test
    void test_is() {
        Actions actions;

        actions = when(null).is(t -> true);
        assertTrue(actions.isMatching());

        actions = when(null).is(t -> false);
        assertFalse(actions.isMatching());
    }
}