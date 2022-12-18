package com.maxzxwd.modules;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import com.maxzxwd.services.PageRenderer;
import com.maxzxwd.services.impl.PageRendererImp;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.inject.Singleton;

@Module(includes = PageRendererModule.PageRendererBindsModule.class)
public class PageRendererModule {
    @Provides
    @Singleton
    public TemplateEngine providesTemplateEngine() {

        var resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");

        var templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        return templateEngine;
    }

    @Provides
    @Singleton
    public HtmlCompressor providesHtmlCompressor() {

        var compressor = new HtmlCompressor();
        compressor.setCompressCss(true);
        compressor.setRemoveSurroundingSpaces(HtmlCompressor.BLOCK_TAGS_MAX);

        return compressor;
    }

    @Module
    public interface PageRendererBindsModule {
        @Binds
        @Singleton
        PageRenderer bindPageRenderer(PageRendererImp impl);
    }
}
