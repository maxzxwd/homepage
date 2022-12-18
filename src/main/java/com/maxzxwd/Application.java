package com.maxzxwd;

import com.maxzxwd.components.DaggerApplicationComponent;

public class Application {

    public static void main(String... args) {
        DaggerApplicationComponent.create().applicationService().run(args);
    }
}