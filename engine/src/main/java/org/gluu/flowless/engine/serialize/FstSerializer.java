package org.gluu.flowless.engine.serialize;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * Warning: This serialization strategy is not implemented yet
 */
@ApplicationScoped
public class FstSerializer implements ObjectSerializer {
    
    @Inject
    private Logger logger;

    @Override
    public Object deserialize(InputStream in) throws IOException {
        return null;
    }
    
    @Override
    public void serialize(Object data, OutputStream out) throws IOException {         
    }
    
    @Override
    public Type getType() {
        return Type.FST;
    }
    
    @PostConstruct
    private void init() {
        
    }
    
}
