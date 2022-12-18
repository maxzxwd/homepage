package com.maxzxwd.components;

import com.maxzxwd.modules.ApplicationModule;
import com.maxzxwd.services.ApplicationService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {
    ApplicationService applicationService();
}
