package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.snowmantheater.warden.Validator.when;
import static com.snowmantheater.warden.predicate.Predicates.Before;
import static com.snowmantheater.warden.predicate.Predicates.EqualTo;
import static com.snowmantheater.warden.predicate.Predicates.LessThan;
import static com.snowmantheater.warden.predicate.Predicates.NotEqualTo;
import static com.snowmantheater.warden.predicate.Predicates.NotNull;
import static com.snowmantheater.warden.predicate.Predicates.Null;
import static com.snowmantheater.warden.predicate.Predicates.eq;
import static com.snowmantheater.warden.predicate.Predicates.lt;
import static com.snowmantheater.warden.predicate.Predicates.ne;

/**
 * {@link UseCases} provides various test methods to demonstrate the use of fluid method calls in Warden.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class UseCases {
    @Test
    @DisplayName("Example: Nullability")
    public void example_nullability() {
        when(null).is(Null()).accept();
        when(1).is(Null()).reject();
        when(null).is(NotNull()).reject();
        when(1).is(NotNull()).accept();
    }

    @Test
    @DisplayName("Example: Equality")
    public void example_equality() {
        when(1).is(EqualTo(1)).accept();
        when(1).is(EqualTo(2)).reject();
        when("a").is(NotEqualTo("a")).reject();
        when("a").is(NotEqualTo("b")).accept();
    }

    @Test
    @DisplayName("Example: Equality (shorthand)")
    public void example_equality_shorthand() {
        when(1).is(eq(1)).accept();
        when(1).is(eq(2)).reject();
        when("a").is(ne("a")).reject();
        when("a").is(ne("b")).accept();
    }

    @Test
    @DisplayName("Example: Relativity")
    public void example_relativity() {
        when(1).is(LessThan(3)).accept();
        when(3).is(LessThan(1)).reject();
        when("A").is(Before("M")).accept();
        when("Z").is(Before("M")).reject();
    }

    @Test
    @DisplayName("Example: Relativity (shorthand)")
    public void example_relativity_shorthand() {
        when(1).is(lt(3)).accept();
        when(3).is(lt(1)).reject();
    }

    @Test
    @DisplayName("Example: Compound Predicates")
    public void example_compound() {
        when(4).is(EqualTo(3).or(LessThan(0))).reject();
    }
}
