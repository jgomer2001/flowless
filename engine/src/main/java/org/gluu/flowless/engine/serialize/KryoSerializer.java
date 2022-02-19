package org.gluu.flowless.engine.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.gluu.flowless.engine.service.ActionService;
import org.slf4j.Logger;

@ApplicationScoped
public class KryoSerializer implements ObjectSerializer {
    
    @Inject
    private Logger logger;

    @Inject
    private ActionService actionService;
    
    private ThreadLocal<Kryo> kryos;
    
    @Override
    public Object deserialize(InputStream in) throws IOException {
        logger.trace("Kryodeserializing");
        Input input = new Input(in);
        //If input is closed, the Input's InputStream is closed
        return kryos.get().readClassAndObject(input);
    }
    
    @Override
    public void serialize(Object data, OutputStream out) throws IOException {
        logger.debug("Kryoserializing");
        Output output = new Output(out);
        kryos.get().writeClassAndObject(output, data);
        output.flush();
    }
           
    @Override
    public Type getType() {
        return Type.KRYO;
    }
    
    @PostConstruct
    private void init() {
        
        Log.DEBUG();
        kryos = new ThreadLocal<Kryo>() {
            
            @Override
            protected Kryo initialValue() {
                Kryo kryo = new Kryo();
                kryo.setRegistrationRequired(false);
                kryo.setReferences(true);
                kryo.setClassLoader(actionService.getClassLoader());
                kryo.setOptimizedGenerics(false);
                return kryo;
            }
            
        };

    }
    
}
