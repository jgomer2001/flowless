package org.gluu.flowless.engine.serialize;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface ObjectSerializer {

    Object deserialize(InputStream in) throws IOException;
    void serialize(Object data, OutputStream out) throws IOException;
    Type getType();
    
}
