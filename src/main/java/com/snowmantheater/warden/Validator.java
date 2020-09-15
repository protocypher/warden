package com.snowmantheater.warden;

import java.util.function.Predicate;

/**
 * {@link Validator} provides a grammar construct to cleanly execute validation actions on values if they match given
 * Predicate tests.
 */
public class Validator {
    private final Object value;
    private final RejectionMessages messages;

    /**
     * Creates a {@link Validator} for the {@code value} using {@code messages} to create rejection messages.
     *
     * @param value The tested value
     * @param messages The message factory
     */
    private Validator(Object value, RejectionMessages messages) {
        this.value = value;
        this.messages = messages;
    }

    /**
     * Returns a {@link Validator} which will evaluate a simple {@code value}.
     *
     * @param value The tested value
     *
     * @return A Validator which will evaluate a simple value
     */
    public static Validator when(Object value) {
        return new Validator(value, RejectionMessages.of(value));
    }

    /**
     * Returns a {@link Validator} which will evaluate a {@code name}ed {@code value}.
     *
     * @param value The tested value
     * @param name The name of the value
     *
     * @return A Validator which will evaluate a named value
     */
    public static Validator when(String name, Object value) {
        return new Validator(value, RejectionMessages.of(name, value));
    }

    /**
     * Returns an appropriate {@link PredicateActions} which will operate on whether {@code value} passes the given
     * {@link Predicate} test.
     *
     * @param predicate The given Predicate
     *
     * @return An appropriate PredicateActions
     */
    public PredicateActions matches(Predicate<Object> predicate) {
        if(predicate.test(value)) {
            return PredicateActions.matching(value, messages);
        } else {
            return PredicateActions.notMatching(value, messages);
        }
    }
}
