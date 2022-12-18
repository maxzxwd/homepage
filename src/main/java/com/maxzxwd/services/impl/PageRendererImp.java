package com.maxzxwd.services.impl;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import com.maxzxwd.exceptions.RendererException;
import com.maxzxwd.services.PageRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.inject.Inject;
import java.util.Map;

public class PageRendererImp implements PageRenderer {

    private final Logger log = LogManager.getLogger(getClass());

    private final TemplateEngine templateEngine;
    private final HtmlCompressor htmlCompressor;

    @Inject
    public PageRendererImp(TemplateEngine templateEngine, HtmlCompressor htmlCompressor) {
        this.templateEngine = templateEngine;
        this.htmlCompressor = htmlCompressor;
    }

    @Override
    public String render(String template, Object model) {
        var context = new Context(null, Map.of("model", model));

        try {
            return htmlCompressor.compress(templateEngine.process("main", context));
        } catch (Throwable e) {
            log.error("Can't render page", e);
            throw new RendererException("Can't render page ", e);
        }
    }
}
