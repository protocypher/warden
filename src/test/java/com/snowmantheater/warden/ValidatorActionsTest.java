package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ValidatorActionsTest {
    @Test
    @DisplayName("Given value=null, calling getValue() returns null")
    public void given_value_is_null_calling_getValue_returns_null() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        assertNull(actions.getValue());
    }

    @Test
    @DisplayName("Given value=3, calling getValue() returns 3")
    public void given_value_is_3_calling_getValue_returns_3() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(3, false, messages);
        assertEquals(3, actions.getValue());
    }

    @Test
    @DisplayName("Given value=\"A\", calling getValue() returns \"A\"")
    public void given_value_is_A_calling_getValue_returns_A() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions("A", false, messages);
        assertEquals("A", actions.getValue());
    }

    @Test
    @DisplayName("Given matching=true, calling isMatching() returns TRUE")
    public void given_matching_is_true_calling_isMatching_returns_TRUE() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);
        assertTrue(actions.isMatching());
    }

    @Test
    @DisplayName("Given matching=false, calling isMatching() returns FALSE")
    public void given_matching_is_false_calling_isMatching_returns_FALSE() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        assertFalse(actions.isMatching());
    }

    @Test
    @DisplayName("Given matching=true, calling eval() returns TRUE")
    public void given_matching_is_true_calling_eval_returns_TRUE() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);
        assertTrue(actions.eval());
    }

    @Test
    @DisplayName("Given matching=false, calling eval() returns FALSE")
    public void given_matching_is_false_calling_eval_returns_FALSE() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        assertFalse(actions.eval());
    }

    @Test
    @DisplayName("Given matching=true, calling reject() throws ValidationException")
    public void given_matching_is_true_calling_reject_throws_Exception() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);

        try {
            actions.reject();
            fail();
        } catch(ValidationException e) {
            assertNull(e.getValue());
            assertEquals("PREFIX", e.getMessage());
        }
    }

    @Test
    @DisplayName("Given matching=false, calling reject() noop")
    public void given_matching_is_false_calling_reject_noop() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        actions.reject();
    }

    @Test
    @DisplayName("Given matching=true, calling reject(\"reason\") throws ValidationException")
    public void given_matching_is_true_calling_reject_reason_throws_Exception() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);

        try {
            actions.reject("reason");
            fail();
        } catch(ValidationException e) {
            assertNull(e.getValue());
            assertEquals("PREFIX: reason", e.getMessage());
        }
    }

    @Test
    @DisplayName("Given matching=false, calling reject(\"reason\") noop")
    public void given_matching_is_false_calling_reject_reason_noop() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        actions.reject("reason");
    }

    @Test
    @DisplayName("Given matching=true, calling reject(Exception) throws ValidationException")
    public void given_matching_is_true_calling_reject_Exception_throws_Exception() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);
        Exception exception = new Exception("ex reason");

        try {
            actions.reject(exception);
            fail();
        } catch(ValidationException e) {
            assertNull(e.getValue());
            assertEquals("PREFIX: ex reason", e.getMessage());
        }
    }

    @Test
    @DisplayName("Given matching=false, calling reject(Exception) noop")
    public void given_matching_is_false_calling_reject_Exception_noop() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        Exception exception = new Exception("ex reason");
        actions.reject(exception);
    }

    @Test
    @DisplayName("Given matching=true, calling accept() noop")
    public void given_matching_is_true_calling_accept_noop() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);
        actions.accept();
    }

    @Test
    @DisplayName("Given matching=false, calling accept() throws ValidationException")
    public void given_matching_is_false_calling_accept_throws_Exception() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);

        try {
            actions.accept();
            fail();
        } catch(ValidationException e) {
            assertNull(e.getValue());
            assertEquals("PREFIX", e.getMessage());
        }
    }

    @Test
    @DisplayName("Given matching=true, calling raise(NullPointerException) throws NullPointerException")
    public void given_matching_is_true_calling_raise_NPE_throws_NPE() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, true, messages);

        try {
            actions.raise(() -> new NullPointerException("NPE Test"));
            fail();
        } catch(NullPointerException e) {
            assertEquals("NPE Test", e.getMessage());
        }
    }

    @Test
    @DisplayName("Given matching=false, calling raise(NullPointerException) noop")
    public void given_matching_is_false_calling_raise_NPE_noop() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(null, false, messages);
        actions.raise(() -> new NullPointerException("NPE Test"));
    }

    @Test
    @DisplayName("Given matching=true, calling execute(Consumer) calls Consumer")
    public void given_matching_is_true_calling_execute_Consumer_calls_Consumer() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(3, true, messages);
        TestConsumer consumer = new TestConsumer();

        actions.execute(consumer);

        assertTrue(consumer.activated);
        assertEquals(3, consumer.consumed);
    }

    @Test
    @DisplayName("Given matching=false, calling execute(Consumer) noop")
    public void given_matching_is_false_calling_execute_Consumer_noop() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(3, false, messages);
        TestConsumer consumer = new TestConsumer();

        actions.execute(consumer);

        assertFalse(consumer.activated);
        assertNull(consumer.consumed);
    }

    @Test
    @DisplayName("Given matching=true, calling executeOrElse(A, B) calls A")
    public void given_matching_is_true_calling_executeOrElse_A_B_calls_A() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(3, true, messages);
        TestConsumer matchConsumer = new TestConsumer();
        TestConsumer noMatchConsumer = new TestConsumer();

        actions.executeOrElse(matchConsumer, noMatchConsumer);

        assertTrue(matchConsumer.activated);
        assertEquals(3, matchConsumer.consumed);
        assertFalse(noMatchConsumer.activated);
        assertNull(noMatchConsumer.consumed);
    }

    @Test
    @DisplayName("Given matching=false, calling executeOrElse(A, B) calls B")
    public void given_matching_is_false_calling_executeOrElse_A_B_calls_B() {
        Messages messages = new TestMessages();
        ValidatorActions actions = new ValidatorActions(3, false, messages);
        TestConsumer matchConsumer = new TestConsumer();
        TestConsumer noMatchConsumer = new TestConsumer();

        actions.executeOrElse(matchConsumer, noMatchConsumer);

        assertFalse(matchConsumer.activated);
        assertNull(matchConsumer.consumed);
        assertTrue(noMatchConsumer.activated);
        assertEquals(3, noMatchConsumer.consumed);
    }

    // =================================================================================================================

    private static class TestConsumer implements Consumer<Object> {
        boolean activated = false;
        Object consumed = null;

        @Override
        public void accept(Object o) {
            activated = true;
            consumed = o;
        }
    }
}
