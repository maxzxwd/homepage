package com.maxzxwd.modules;

import com.maxzxwd.services.ApplicationService;
import com.maxzxwd.services.impl.ApplicationServiceImpl;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;

@Module(includes = {VertxModule.class, SchedulerModule.class, PageRendererModule.class})
public interface ApplicationModule {
    @Binds
    @Singleton
    ApplicationService bindApplicationService(ApplicationServiceImpl impl);
}
