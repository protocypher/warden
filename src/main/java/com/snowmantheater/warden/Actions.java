package com.snowmantheater.warden;

import lombok.Getter;
import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * {@link Actions} are methods which have polar functionality that selected behavior based on whether a value
 * matches a {@code Predicate} or not.
 *
 * @author benjamin@snowmantheater.com
 * @version 1.0.0
 */
public class Actions {
    private final Value value;

    @Getter
    private final boolean matching;

    /**
     * Creates a new {@link Actions} for {@code name}, {@code value} and {@code matching}.
     *
     * @param value The given validation value
     * @param predicate Whether actions should reflect a matching Predicate or not
     */
    Actions(@NonNull Value value, @NonNull Predicate<Object> predicate) {
        this.value = value;

        // Only run once; in case the caller created inappropriate Predicates which have side effects
        matching = predicate.test(value.getValue());
    }

    /**
     * If the value matches the {@code Predicate}, then throw a {@link Rejection} with a message noting the value.
     */
    public void reject() {
        if (matching) {
            throw new Rejection(value.getValue(), getRejectingMessage());
        }
    }

    /**
     * If the value matches the {@code Predicate}, then throw a {@link Rejection} with a message noting the value and
     * {@code reason}.
     *
     * @param reason The given rejection reason
     */
    public void reject(@NonNull String reason) {
        if (matching) {
            throw new Rejection(value.getValue(), getRejectingMessage(reason));
        }
    }

    /**
     * If the value matches the {@code Predicate}, then perform no action, otherwise throw a {@link Rejection} with a
     * message noting the value.
     */
    public void accept() {
        if (!matching) {
            throw new Rejection(value.getValue(), getRejectingMessage());
        }
    }

    /**
     * If the value matches the {@code Predicate}, then throw the {@link Throwable} supplied by {@code supplier}.
     *
     * @param supplier The Throwable Supplier
     * @param <X> The type of Throwable
     *
     * @throws X When the value matches the Predicate
     */
    public <X extends Throwable> void raise(@NonNull Supplier<? extends X> supplier) throws X {
        if (matching) {
            throw supplier.get();
        }
    }

    /**
     * If the value matches the {@code Predicate}, then call {@code action.accept()} with the value.
     *
     * @param action The action to perform if the value matches the Predicate
     */
    public void perform(@NonNull Consumer<Object> action) {
        if (matching) {
            action.accept(value.getValue());
        }
    }

    /**
     * If the value matches the {@code Predicate}, then call {@code action.accept()} with the value, otherwise call
     * {@code altAction.accept()} with the value.
     *
     * @param action The action to perform if the value matches the Predicate
     * @param altAction The action to perform if the value does not match the Predicate
     */
    public void performOrElse(@NonNull Consumer<Object> action, @NonNull Consumer<Object> altAction) {
        if (matching) {
            action.accept(value.getValue());
        } else {
            altAction.accept(value.getValue());
        }
    }

    /**
     * If the value matches the {@code Predicate}, then call {@code logger.accept()} with a basic, rejection reason.
     *
     * @param logger The adapter for logging a given message
     */
    public void logReject(@NonNull Consumer<String> logger) {
        if (matching) {
            logger.accept(getRejectingMessage());
        }
    }

    /**
     * If the value matches the {@code Predicate}, then call {@code logger.accept()} with a rejection message containing
     * {@code reason}.
     *
     * @param reason The given reason for the rejection
     * @param logger The adapter for logging a given message
     */
    public void logReject(@NonNull String reason, @NonNull Consumer<String> logger) {
        if (matching) {
            logger.accept(getRejectingMessage(reason));
        }
    }

    /**
     * If the value matches the {@code Predicate}, then call {@code logger.accept()} with a basic, acceptance reason.
     *
     * @param logger The adapter for logging a given message
     */
    public void logAccept(@NonNull Consumer<String> logger) {
        if (matching) {
            logger.accept(getAcceptingMessage());
        }
    }

    /**
     * If the value matches the {@code Predicate}, then call {@code logger.accept()} with an acceptance message
     * containing {@code reason}.
     *
     * @param reason The given reason for the acceptance
     * @param logger The adapter for logging a given message
     */
    public void logAccept(@NonNull String reason, @NonNull Consumer<String> logger) {
        if (matching) {
            logger.accept(getAcceptingMessage(reason));
        }
    }

    private String getRejectingMessage() {
        return "Rejecting " + value + ".";
    }

    private String getRejectingMessage(String reason) {
        return "Rejecting " + value + ": " + reason;
    }

    private String getAcceptingMessage() {
        return "Accepting " + value + ".";
    }

    private String getAcceptingMessage(String reason) {
        return "Accepting " + value + ": " + reason;
    }
}
