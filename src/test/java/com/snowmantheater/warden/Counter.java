package com.snowmantheater.warden;

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
