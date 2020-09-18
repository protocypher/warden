package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NonMatchingPredicateActionsTest {
    @Test
    @DisplayName("Calling reject() NoOp")
    public void calling_reject_NoOp() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        actions.reject();
    }

    @Test
    @DisplayName("Calling reject(null) NoOp")
    public void calling_reject_w_null_NoOp() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        actions.reject(null);
    }

    @Test
    @DisplayName("Calling reject(\"reason\") NoOp")
    public void calling_reject_w_reason_NoOp() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        actions.reject("reason");
    }

    @Test
    @DisplayName("Calling accept() throws ValidationException")
    public void calling_accept_throws_ValidationException() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        assertThrows(ValidationException.class, actions::accept);
    }

    @Test
    @DisplayName("Calling raise(Supplier<Exception>) NoOp")
    public void calling_raise_w_Supplier$Exception_NoOp() {
        PredicateActions actions = new NonMatchingPredicateActions(null);

        try {
            actions.raise(Exception::new);
        } catch(Exception ignored) {
            // NoOp
        }
    }

    @Test
    @DisplayName("Calling perform(action) NoOp")
    public void calling_perform_w_action_NoOp() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        Counter actionCounter = new Counter();
        Consumer<Object> action = o -> actionCounter.increment();

        actions.perform(action);
        assertFalse(actionCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling performOrElse(action, altAction) calls altAction.accept()")
    public void calling_performOrElse_w_action_altAction_calls_altAction$accept() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        Counter actionCounter = new Counter();
        Counter altActionCounter = new Counter();
        Consumer<Object> action = o -> actionCounter.increment();
        Consumer<Object> altAction = o -> altActionCounter.increment();

        actions.performOrElse(action, altAction);
        assertFalse(actionCounter.hasCounted());
        assertTrue(altActionCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logReject(logAdapter) calls logAdapter.accept()")
    public void calling_logReject_w_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logReject(logAdapter);
        assertTrue(logCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logReject(\"reason\", logAdapter) calls logAdapter.accept()")
    public void calling_logReject_w_reason_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logReject("reason", logAdapter);
        assertTrue(logCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logAccept(logAdapter) calls logAdapter.accept()")
    public void calling_logAccept_w_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logAccept(logAdapter);
        assertTrue(logCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logAccept(\"reason\", logAdapter) calls logAdapter.accept()")
    public void calling_logAccept_w_reason_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new NonMatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logAccept("reason", logAdapter);
        assertTrue(logCounter.hasCounted());
    }
}