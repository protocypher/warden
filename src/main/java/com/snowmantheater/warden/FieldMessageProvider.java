package com.snowmantheater.warden;

import static java.util.Objects.requireNonNull;

class FieldMessageProvider extends AbstractMessageProvider {
    FieldMessageProvider(String name, Object value) {
        super(requireNonNull(name) + "='" + value + "'");
    }
}
