package com.maxzxwd.modules;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Module
public class SchedulerModule {
    @Provides
    @Singleton
    public ScheduledExecutorService providesScheduler() {
        return Executors.newScheduledThreadPool(10);
    }
}
