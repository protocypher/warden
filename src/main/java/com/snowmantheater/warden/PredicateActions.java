package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * {@link PredicateActions} contains methods which conditionally execute based on whether a given value matches a
 * {@code Predicate} test.
 */
public class PredicateActions {
    private final Object value;
    private final boolean matching;
    private final RejectionMessages messages;

    /**
     * Creates a new {@link PredicateActions} to execute on {@code value} if it {@code matching} a {@code Predicate}
     * test. Rejection messages to exceptions or callers are provided by {@code messages}.
     *
     * @param value The value under scrutiny
     * @param matching Whether value matches the Predicate test
     * @param messages The source of messages for expressing rejection
     *
     * @throws NullPointerException If messages is null
     */
    private PredicateActions(Object value, RejectionMessages messages, boolean matching) {
        this.value = value;
        this.messages = messages;
        this.matching = matching;
    }

    /**
     * Creates a {@link PredicateActions} for {@code value}. All methods will execute as if {@code value} matches the
     * {@code Predicate} test. {@code messages} is used to create messages for exceptions or callers.
     *
     * @param value The matching value
     * @param messages The messages creator
     *
     * @return A PredicateActions for matching value
     */
    public static PredicateActions matching(Object value, RejectionMessages messages) {
        return new PredicateActions(value, requireNonNull(messages), true);
    }

    /**
     * Creates a {@link PredicateActions} for {@code value}. All methods will execute as if {@code value} does not
     * match the {@code Predicate} test. {@code messages} is used to create messages for exceptions or callers.
     *
     * @param value The non matching value
     * @param messages The messages creator
     *
     * @return A PredicateActions for not matching value
     */
    public static PredicateActions notMatching(Object value, RejectionMessages messages) {
        return new PredicateActions(value, requireNonNull(messages), false);
    }

    /**
     * Returns whether this PredicateActions is matching or not.
     *
     * @return Whether this PredicateActions is matching or not
     */
    public boolean isMatching() {
        return matching;
    }

    /**
     * If {@code value} matches the Predicate test, then reject it by throwing a {@link RejectionException} with a
     * basic message.
     *
     * @throws RejectionException If value matches the Predicate test
     */
    public void reject() {
        if(matching) {
            throw new RejectionException(value, messages.create());
        }
    }

    /**
     * If {@code value} matches the Predicate test, then reject it by throwing a {@link RejectionException} with a
     * message that contains {@code reason}.
     *
     * @param reason The specific, rejection reason
     *
     * @throws RejectionException If value matches the Predicate test
     */
    public void rejectWith(String reason) {
        if(matching) {
            throw new RejectionException(value, messages.createWith(reason));
        }
    }

    /**
     * If {@code value} matches the Predicate test, then reject it by throwing a {@link RejectionException} with a
     * message that contains the {@code cause} reason.
     *
     * @param cause The specific, rejection cause
     *
     * @throws RejectionException If value matches the Predicate test
     */
    public void rejectFor(Throwable cause) {
        if(matching) {
            throw new RejectionException(value, messages.createFor(cause), cause);
        }
    }

    /**
     * If {@code value} matches the Predicate test, then accept it <i>(do nothing)</i>, otherwise reject it as if
     * {@code reject()} were called.
     *
     * @throws RejectionException If value did <b>not</b> match the Predicate test
     */
    public void accept() {
        if(!matching) {
            throw new RejectionException(value, messages.create());
        }
    }

    /**
     * If {@code value} matches the Predicate test, then raise the exception provided by {@code supplier}.
     *
     * @param supplier The exception supplier
     * @param <X> The type of exception
     *
     * @throws X If value matches the Predicate test
     */
    public <X extends Throwable> void raise(Supplier<? extends X> supplier) throws X {
        if(matching) {
            throw supplier.get();
        }
    }

    /**
     * If {@code value} matches the Predicate test, then perform {@code action} with {@code value} otherwise do nothing.
     *
     * @param action The Consumer to execute on value if it matches the Predicate test
     */
    public void perform(Consumer<Object> action) {
        if(matching) {
            action.accept(value);
        }
    }

    /**
     * If {@code value} matches the Predicate test, then perform {@code action} with {@code value} otherwise perform
     * {@code alternate} on the same {@code value}.
     *
     * @param action The Consumer to execute on value if it matches the Predicate test
     * @param alternate The Consumer to execute on value if it <b>does not</b> match the Predicate test
     */
    public void performOrElse(Consumer<Object> action, Consumer<Object> alternate) {
        if(matching) {
            action.accept(value);
        } else {
            alternate.accept(value);
        }
    }
}
