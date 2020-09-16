package com.snowmantheater.warden;

class ValueMessageProvider extends AbstractMessageProvider {
    ValueMessageProvider(Object value) {
        super("'" + value + "'");
    }
}
