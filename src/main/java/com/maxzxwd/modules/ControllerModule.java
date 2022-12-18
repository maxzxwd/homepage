package com.maxzxwd.modules;

import com.maxzxwd.controllers.Controller;
import com.maxzxwd.controllers.ResourcesController;
import com.maxzxwd.controllers.MainController;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

import javax.inject.Singleton;

@Module
public interface ControllerModule {

    @Binds
    @IntoSet
    @Singleton
    Controller bindMainController(MainController impl);

    @Binds
    @IntoSet
    @Singleton
    Controller bindResourcesController(ResourcesController impl);
}
