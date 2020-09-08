package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {
    @Test
    @DisplayName("Calling is(Predicate{true}) returns TRUE")
    public void calling_is_Predicate_true_returns_TRUE() {
        Evaluator evaluator = new Evaluator(null);
        assertTrue(evaluator.is(t -> true));
    }

    @Test
    @DisplayName("Calling is(Predicate{false}) returns FALSE")
    public void calling_is_Predicate_false_returns_FALSE() {
        Evaluator evaluator = new Evaluator(null);
        assertTrue(evaluator.is(t -> true));
    }

    @Test
    @DisplayName("Given value=1, calling is(Predicate{t.equals(1)}) returns TRUE")
    public void given_value_is_1_calling_is_Predicate_t_equals_1_returns_TRUE() {
        Evaluator evaluator = new Evaluator(1);
        assertTrue(evaluator.is(t -> t.equals(1)));
    }

    @Test
    @DisplayName("Given value=0, calling is(Predicate{t.equals(1)}) returns FALSE")
    public void given_value_is_0_calling_is_Predicate_t_equals_1_returns_FALSE() {
        Evaluator evaluator = new Evaluator(0);
        assertFalse(evaluator.is(t -> t.equals(1)));
    }
}
