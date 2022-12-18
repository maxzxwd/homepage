package com.maxzxwd.modules;

import com.maxzxwd.controllers.Controller;
import dagger.Module;
import dagger.Provides;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxBuilder;
import io.vertx.ext.web.Router;

import javax.inject.Singleton;
import java.util.Set;

@Module(includes = ControllerModule.class)
public class VertxModule {
    @Provides
    @Singleton
    public Vertx providesVertx() {

        System.setProperty("vertx.disableDnsResolver", "true");
        return new VertxBuilder().init().vertx();
    }

    @Provides
    @Singleton
    public Router provideRouter(Vertx vertx, Set<Controller> controllers) {

        var router = Router.router(vertx);

        controllers.forEach(controller -> controller.register(router));

        return router;
    }
}
