package com.snowmantheater.warden;

import org.junit.jupiter.api.Test;

import static com.snowmantheater.warden.Validator.when;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void test_when_X() {

    }

    @Test
    void test_when_X_X() {

    }

    @Test
    void test_when_X_X_X() {

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