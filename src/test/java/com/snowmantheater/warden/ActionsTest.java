package com.snowmantheater.warden;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ActionsTest {

    @Test
    void test_Constructor() {
        Actions actions;
        Value value = Value.of(null);

        assertThrows(NullPointerException.class, () -> new Actions(null, true));
        assertThrows(NullPointerException.class, () -> new Actions(null, false));

        actions = new Actions(value, true);
        assertTrue(actions.isMatching());

        actions = new Actions(value, false);
        assertFalse(actions.isMatching());
    }

    @Test
    void test_reject() {
        Value value = Value.of(null);

        Actions matching = new Actions(value, true);
        assertThrows(Rejection.class, matching::reject);

        Actions nonMatching = new Actions(value, false);
        assertDoesNotThrow((Executable) nonMatching::reject);
    }

    @Test
    void test_reject_reason() {
        Value value = Value.of(null);
        String reason = "reason";

        Actions matching = new Actions(value, true);
        assertThrows(Rejection.class, () -> matching.reject(reason));

        Actions nonMatching = new Actions(value, false);
        assertDoesNotThrow(() -> nonMatching.reject(reason));
    }

    @Test
    void test_accept() {
        Value value = Value.of(null);

        Actions matching = new Actions(value, true);
        assertDoesNotThrow((Executable) matching::accept);

        Actions nonMatching = new Actions(value, false);
        assertThrows(Rejection.class, nonMatching::accept);
    }

    @Test
    void test_raise() {
        Value value = Value.of(null);

        Actions matching = new Actions(value, true);
        assertThrows(IllegalArgumentException.class, () -> matching.raise(IllegalArgumentException::new));

        Actions notMatching = new Actions(value, false);
        assertDoesNotThrow(() -> notMatching.raise(IllegalArgumentException::new));
    }

    @Test
    void test_perform() {
        String string = "A";
        Value value = Value.of(string);
        Consumer<Object> consumer;

        consumer = mock(Consumer.class);
        Actions matching = new Actions(value, true);
        matching.perform(consumer);
        verify(consumer, times(1)).accept(string);

        consumer = mock(Consumer.class);
        Actions notMatching = new Actions(value, false);
        notMatching.perform(consumer);
        verify(consumer, never()).accept(any());
    }

    @Test
    void test_performOrElse() {
        String string = "A";
        Value value = Value.of(string);
        Consumer<Object> consumer;
        Consumer<Object> altConsumer;

        consumer = mock(Consumer.class);
        altConsumer = mock(Consumer.class);
        Actions matching = new Actions(value, true);
        matching.performOrElse(consumer, altConsumer);
        verify(consumer, times(1)).accept(string);
        verify(altConsumer, never()).accept(any());

        consumer = mock(Consumer.class);
        altConsumer = mock(Consumer.class);
        Actions notMatching = new Actions(value, false);
        notMatching.performOrElse(consumer, altConsumer);
        verify(consumer, never()).accept(any());
        verify(altConsumer, times(1)).accept(string);
    }

    @Test
    void test_logReject() {
        Value value = Value.of("A");
        String expected = "Rejecting \"A\".";
        Consumer<String> logger;

        logger = mock(Consumer.class);
        Actions matching = new Actions(value, true);
        matching.logReject(logger);
        verify(logger, times(1)).accept(expected);

        logger = mock(Consumer.class);
        Actions notMatching = new Actions(value, false);
        notMatching.logReject(logger);
        verify(logger, never()).accept(any());
    }

    @Test
    void test_logReject_reason() {
        Value value = Value.of("A");
        String reason = "reason";
        String expected = "Rejecting \"A\": reason";
        Consumer<String> logger;

        logger = mock(Consumer.class);
        Actions matching = new Actions(value, true);
        matching.logReject(reason, logger);
        verify(logger, times(1)).accept(expected);

        logger = mock(Consumer.class);
        Actions notMatching = new Actions(value, false);
        notMatching.logReject(reason, logger);
        verify(logger, never()).accept(any());
    }

    @Test
    void test_logAccept() {
        Value value = Value.of("A");
        String expected = "Accepting \"A\".";
        Consumer<String> logger;

        logger = mock(Consumer.class);
        Actions matching = new Actions(value, true);
        matching.logAccept(logger);
        verify(logger, times(1)).accept(expected);

        logger = mock(Consumer.class);
        Actions notMatching = new Actions(value, false);
        notMatching.logAccept(logger);
        verify(logger, never()).accept(any());
    }

    @Test
    void test_logAccept_reason() {
        Value value = Value.of("A");
        String reason = "reason";
        String expected = "Accepting \"A\": reason";
        Consumer<String> logger;

        logger = mock(Consumer.class);
        Actions matching = new Actions(value, true);
        matching.logAccept(reason, logger);
        verify(logger, times(1)).accept(expected);

        logger = mock(Consumer.class);
        Actions notMatching = new Actions(value, false);
        notMatching.logAccept(reason, logger);
        verify(logger, never()).accept(any());
    }
}