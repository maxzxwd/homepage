package com.maxzxwd.controllers;

import com.maxzxwd.models.MainModel;
import com.maxzxwd.services.PageRenderer;
import io.vertx.ext.web.Router;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class MainController implements Controller {

    private static final AtomicLong COUNTER = new AtomicLong(1);

    private volatile String prerenderedMain = "Something goes wrong. Please contact maxzxwd835@gmail.com";

    @Inject
    public MainController(ScheduledExecutorService scheduler, PageRenderer pageRenderer) {
        scheduler.scheduleWithFixedDelay(() -> {

            var start = System.nanoTime();

            var model = new MainModel(
                    start,
                    (COUNTER.get() % 7) + ".png",
                    COUNTER.get(),
                    LocalDateTime.now()
            );

            prerenderedMain = pageRenderer.render("main", model);

        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    @Override
    public void register(Router router) {
        router.get("/")
                .produces("text/html; charset=utf-8")
                .handler(ctx -> ctx.response()
                        .end(prerenderedMain,
                                event -> COUNTER.getAndAccumulate(1, (prev, x) -> (prev + x) % Long.MAX_VALUE)));
    }
}
