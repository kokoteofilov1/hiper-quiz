package hiper.dao.impl;

import hiper.dao.KeyGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class LongKeyGenerator implements KeyGenerator<Long> {
    public LongKeyGenerator() {
    }

    private AtomicLong sequence = new AtomicLong();

    @Override
    public Long getNextId() {
        return sequence.incrementAndGet();
    }
}
