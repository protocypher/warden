package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface PredicateActions {
    void reject();

    void reject(String reason);

    void accept();

    <X extends Throwable> void raise(Supplier<? extends X> supplier) throws X;

    void perform(Consumer<Object> action);

    void performOrElse(Consumer<Object> action, Consumer<Object> altAction);

    void logReject(Consumer<String> logAdapter);

    void logReject(String reason, Consumer<String> logAdapter);

    void logAccept(Consumer<String> logAdapter);

    void logAccept(String reason, Consumer<String> logAdapter);
}
