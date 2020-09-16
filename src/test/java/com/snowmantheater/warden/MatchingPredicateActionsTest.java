package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class MatchingPredicateActionsTest {
    @Test
    @DisplayName("Calling reject() throws RejectionException")
    public void calling_reject_throws_RejectionException() {
        PredicateActions actions = new MatchingPredicateActions(null);
        assertThrows(RejectionException.class, actions::reject);
    }

    @Test
    @DisplayName("Calling reject(null) throws NPE")
    public void calling_reject_w_null_throws_NPE() {
        PredicateActions actions = new MatchingPredicateActions(null);
        assertThrows(NullPointerException.class, () -> actions.reject(null));
    }

    @Test
    @DisplayName("Calling reject(\"reason\") throws RejectionException")
    public void calling_reject_w_reason_throws_RejectionException() {
        PredicateActions actions = new MatchingPredicateActions(null);
        assertThrows(RejectionException.class, () -> actions.reject("reason"));
    }

    @Test
    @DisplayName("Calling accept() NoOp")
    public void calling_accept_NoOp() {
        PredicateActions actions = new MatchingPredicateActions(null);
        actions.accept();
    }

    @Test
    @DisplayName("Calling Raise(Supplier<Exception>) throws Exception")
    public void calling_raise_w_Supplier$Exception_throws_Exception() {
        PredicateActions actions = new MatchingPredicateActions(null);
        assertThrows(Exception.class, () -> actions.raise(Exception::new));
    }

    @Test
    @DisplayName("Calling perform(action) calls action.accept()")
    public void calling_perform_w_action_calls_action$accept() {
        PredicateActions actions = new MatchingPredicateActions(null);
        Counter actionCounter = new Counter();
        Consumer<Object> action = o -> actionCounter.increment();

        actions.perform(action);
        assertTrue(actionCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling performOrElse(action, altAction) calls action.accept()")
    public void calling_performOrElse_w_action_altAction_calls_action$accept() {
        PredicateActions actions = new MatchingPredicateActions(null);
        Counter actionCounter = new Counter();
        Counter altActionCounter = new Counter();
        Consumer<Object> action = o -> actionCounter.increment();
        Consumer<Object> altAction = o -> altActionCounter.increment();

        actions.performOrElse(action, altAction);
        assertTrue(actionCounter.hasCounted());
        assertFalse(altActionCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logReject(logAdapter) calls logAdapter.accept()")
    public void calling_logReject_w_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new MatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logReject(logAdapter);
        assertTrue(logCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logReject(\"reason\", logAdapter) calls logAdapter.accept()")
    public void calling_logReject_w_reason_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new MatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logReject("reason", logAdapter);
        assertTrue(logCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logAccept(logAdapter) calls logAdapter.accept()")
    public void calling_logAccept_w_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new MatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logAccept(logAdapter);
        assertTrue(logCounter.hasCounted());
    }

    @Test
    @DisplayName("Calling logAccept(\"reason\", logAdapter) calls logAdapter.accept()")
    public void calling_logAccept_w_reason_logAdapter_calls_logAdapter$accept() {
        PredicateActions actions = new MatchingPredicateActions(null);
        Counter logCounter = new Counter();
        Consumer<String> logAdapter = s -> logCounter.increment();

        actions.logAccept("reason", logAdapter);
        assertTrue(logCounter.hasCounted());
    }
}