package org.gluu.flowless.engine.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.gluu.flowless.engine.model.EngineConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ServicesFactory {

    @Inject
    private Logger logger;
    
    @Produces
    public Logger loggerInstance(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
    }
    
    @Produces
    public ObjectMapper mapperInstance() {
        return new ObjectMapper();
    }
    
    @Produces
    @ApplicationScoped
    public EngineConfig engineConfigInstance() {
        logger.info("Creating an instance of Engine Configuration");
        //TODO
        return new EngineConfig();
    }
    
}
