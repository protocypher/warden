package com.snowmantheater.warden;

/**
 * A {@link Counter} is a stateful class accessible through method calls so lambda expressions can call it and retain
 * state outside their context.
 *
 * @version 1.0.0
 * @author benjamin@snowmantheater.com
 */
public class Counter {
    private int count = 0;

    public boolean hasCounted() {
        return count > 0;
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }

    public void increment() {
        count++;
    }

    public void incrementBy(int inc) {
        count += inc;
    }
}
