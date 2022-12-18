package com.maxzxwd.models;

import java.time.LocalDateTime;

public record MainModel(long renderStart, String favicon, long counter, LocalDateTime current) {
    public long elapsed() {
        return (System.nanoTime() - renderStart) / 1000;
    }
}