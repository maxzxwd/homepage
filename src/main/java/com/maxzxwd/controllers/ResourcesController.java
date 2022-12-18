package com.maxzxwd.controllers;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

import javax.inject.Inject;

public class ResourcesController implements Controller {

    @Inject
    public ResourcesController() {}

    @Override
    public void register(Router router) {
        router.route("/favicons/*").handler(StaticHandler.create("favicons"));
        router.route("/images/*").handler(StaticHandler.create("images"));
        router.route("/other/*").handler(StaticHandler.create("other"));
    }
}
