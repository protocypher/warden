package com.snowmantheater.warden;

public interface MessageProvider {
    static MessageProvider of(Object value) {
        return new ValueMessageProvider(value);
    }

    static MessageProvider of(String name, Object value) {
        return new FieldMessageProvider(name, value);
    }

    String getRejectingMessage();

    String getRejectingMessage(String reason);

    String getAcceptingMessage();

    String getAcceptingMessage(String reason);
}
