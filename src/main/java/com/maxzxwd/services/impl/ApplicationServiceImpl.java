package com.maxzxwd.services.impl;

import com.maxzxwd.services.ApplicationService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.lang.management.ManagementFactory;

public class ApplicationServiceImpl implements ApplicationService {

    private final Logger log = LogManager.getLogger(getClass());

    private final Vertx vertx;
    private final Router router;

    @Inject
    public ApplicationServiceImpl(Vertx vertx, Router router) {
        this.vertx = vertx;
        this.router = router;
    }

    @Override
    public void run(String... args) {
        var now = System.currentTimeMillis();

        log.info("Startup completed in {}ms", now - ManagementFactory.getRuntimeMXBean().getStartTime());
        vertx.createHttpServer().requestHandler(router).listen(8080)
                .onSuccess(event -> {

                    log.info("Server started at http://127.0.0.1:{}", event.actualPort());
                });
    }
}
