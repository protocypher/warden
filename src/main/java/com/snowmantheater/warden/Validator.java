package com.snowmantheater.warden;

import java.util.function.Predicate;

/**
 * Classes of this type provide access to {@link ValidatorActions} that can
 * operate on different types of values and variables.
 */
public interface Validator {
    /**
     * Given a {@link Predicate}, evaluate the internal value and return an
     * appropriate {@link ValidatorActions}.
     *
     * @param predicate The {@code Predicate} to evaluate with
     *
     * @return {@code ValidatorActions} appropriate for the value
     */
    ValidatorActions is(Predicate<Object> predicate);
}
