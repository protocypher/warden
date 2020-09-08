package com.snowmantheater.warden;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ValidatorActions {
    private final Object value;
    private final boolean matching;
    private final Messages messages;

    ValidatorActions(Object value, boolean matching, Messages messages) {
        if(messages == null) {
            throw new IllegalArgumentException("`messages` cannot be null");
        }

        this.value = value;
        this.matching = matching;
        this.messages = messages;
    }

    public Object getValue() {
        return value;
    }

    public boolean isMatching() {
        return matching;
    }

    public boolean eval() {
        return isMatching();
    }

    public void reject() {
        if(isMatching()) {
            throw new ValidationException(value, messages.getMessage());
        }
    }

    public void reject(String reason) {
        if(isMatching()) {
            throw new ValidationException(value, messages.getMessage(reason));
        }
    }

    public void reject(Throwable cause) {
        if(isMatching()) {
            throw new ValidationException(value, messages.getMessage(cause), cause);
        }
    }

    public void accept() {
        if(!isMatching()) {
            throw new ValidationException(value, messages.getMessage());
        }
    }

    public <X extends Throwable> void raise(Supplier<? extends X> supplier) throws X {
        if(isMatching()) {
            throw supplier.get();
        }
    }

    public void execute(Consumer<Object> action) {
        if(isMatching()) {
            action.accept(value);
        }
    }

    public void executeOrElse(Consumer<Object> action, Consumer<Object> alternate) {
        if(isMatching()) {
            action.accept(value);
        } else {
            alternate.accept(value);
        }
    }
}
