package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueValidatorTest {
    @Test
    @DisplayName("Calling matches(Predicate[true]) returns MatchingPredicateActions")
    public void calling_matches_with_TruePredicate_returns_MatchingPredicateActions() {
        Validator validator = new ValueValidator(null);
        PredicateActions actions = validator.matches(o -> true);
        assertEquals(actions.getClass(), MatchingPredicateActions.class);
    }

    @Test
    @DisplayName("Calling matches(Predicate[false]) returns NonMatchingPredicateActions")
    public void calling_matches_with_FalsePredicate_returns_NonMatchingPredicateActions() {
        Validator validator = new ValueValidator(null);
        PredicateActions actions = validator.matches(o -> false);
        assertEquals(actions.getClass(), NonMatchingPredicateActions.class);
    }
}