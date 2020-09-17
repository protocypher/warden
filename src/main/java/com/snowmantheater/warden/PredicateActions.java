package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * {@link PredicateActions} are methods which have polar functionality that is selected based on whether a value matches
 * a {@code Predicate} or not.
 */
public interface PredicateActions {
    /**
     * If the value matches the {@code Predicate}, then throw a {@link RejectionException} with a message noting the
     * value.
     */
    void reject();

    /**
     * If the value matches the {@code Predicate}, then throw a {@link RejectionException} with a message noting the
     * value with {@code reason} embedded.
     */
    void reject(String reason);

    /**
     * If the value matches the {@code Predicate}, then perform no action, otherwise throw a {@link RejectionException}
     * with a message noting the value.
     */
    void accept();

    /**
     * If the value matches the {@code Predicate}, then throw the {@link Throwable} supplied by {@code supplier}.
     *
     * @param supplier The Throwable Supplier
     * @param <X> The type of Throwable
     *
     * @throws X When the value matches the Predicate
     */
    <X extends Throwable> void raise(Supplier<? extends X> supplier) throws X;

    /**
     * If the value matches the {@code Predicate}, then call {@code action.accept()} on the value.
     *
     * @param action The action to perform if the value matches the Predicate
     */
    void perform(Consumer<Object> action);

    /**
     * If the value matches the {@code Predicate}, then call {@code action.accept()} on the value, otherwise call
     * {@code altAction.accept()} on the value.
     *
     * @param action The action to perform if the value matches the Predicate
     * @param altAction The action to perform if the value does not match the Predicate
     */
    void performOrElse(Consumer<Object> action, Consumer<Object> altAction);

    /**
     * If the value matches the {@code Predicate}, then call {@code logAdapter.accept()} with a basic, reject reason.
     * It is expected that this consumer will take the {@code String} and log it to a logger.
     *
     * @param logAdapter The adapter Consumer for logging a given message
     */
    void logReject(Consumer<String> logAdapter);

    /**
     * If the value matches the {@code Predicate}, then call {@code logAdapter.accept()} with a reject reason with
     * {@code reason} embedded. It is expected that this consumer will take the {@code String} and log it to a logger.
     *
     * @param logAdapter The adapter Consumer for logging a given message
     */
    void logReject(String reason, Consumer<String> logAdapter);

    /**
     * If the value matches the {@code Predicate}, then call {@code logAdapter.accept()} with a basic, accept reason.
     * It is expected that this consumer will take the {@code String} and log it to a logger.
     *
     * @param logAdapter The adapter Consumer for logging a given message
     */
    void logAccept(Consumer<String> logAdapter);

    /**
     * If the value matches the {@code Predicate}, then call {@code logAdapter.accept()} with a accept reason with
     * {@code reason} embedded. It is expected that this consumer will take the {@code String} and log it to a logger.
     *
     * @param logAdapter The adapter Consumer for logging a given message
     */
    void logAccept(String reason, Consumer<String> logAdapter);
}
