package org.gluu.flowless.engine.serialize;
        
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.gluu.flowless.engine.model.EngineConfig;

@ApplicationScoped
public class SerializerFactory {
    
    @Inject
    private EngineConfig engineConf;
    
    @Inject @Any 
    private Instance<ObjectSerializer> services;
    
    private ObjectSerializer serializer;
    
    public ObjectSerializer get() {
        return serializer;
    }

    @PostConstruct
    private void init() {        
        serializer = services.stream()
                .filter(s -> s.getType().equals(engineConf.getSerializationConf().getSerializerType()))
                .findFirst().orElse(null);                
    }
    

}
