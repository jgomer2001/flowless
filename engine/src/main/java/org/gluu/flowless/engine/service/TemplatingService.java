package org.gluu.flowless.engine.service;

import freemarker.core.OutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.gluu.flowless.engine.exception.TemplateProcessingException;
import org.gluu.flowless.engine.model.EngineConfig;
import org.slf4j.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

@ApplicationScoped
public class TemplatingService {

    @Inject
    private Logger logger;
    
    private Configuration fmConfig;
    
    public String process(String templatePath, Object dataModel, Writer writer, boolean useClassloader)
            throws TemplateProcessingException {
        try {
            //Get template, inject data, and write output
            Template t = useClassloader ? getTemplateFromClassLoader(templatePath) : getTemplate(templatePath);
            t.process(Optional.ofNullable(dataModel).orElse(Collections.emptyMap()), writer);
            return Optional.ofNullable(t.getOutputFormat()).map(OutputFormat::getMimeType).orElse(null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new TemplateProcessingException(e.getMessage(), e);
        }
    }
    
    private Template getTemplate(String path) throws IOException {
        return fmConfig.getTemplate(path);
    }
    
    private Template getTemplateFromClassLoader(String path) throws IOException {
        ClassLoader loader = getClass().getClassLoader();
        Reader reader = new InputStreamReader(loader.getResourceAsStream(path), UTF_8);
        return new Template(path, reader, fmConfig);
    }
    
    @PostConstruct
    private void init() throws IOException {
        fmConfig = new Configuration(Configuration.VERSION_2_3_31);
        fmConfig.setDefaultEncoding(UTF_8.toString());
        //TODO: ?
        //fmConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        fmConfig.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
        fmConfig.setLogTemplateExceptions(false);
        fmConfig.setWrapUncheckedExceptions(true);
        fmConfig.setFallbackOnNullLoopVariable(false);   
        fmConfig.setDirectoryForTemplateLoading(Paths.get(EngineConfig.ROOT_DIR).toFile());
    }
    
}
