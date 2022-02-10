package org.gluu.flowless.engine.model;

import org.gluu.flowless.engine.serialize.Type;

public class SerializationConfig {
    
    private boolean skipSerialization;
    private Type serializerType = Type.KRYO;

    public Type getSerializerType() {
        return serializerType;
    }

    public void setSerializerType(Type serializerType) {
        this.serializerType = serializerType;
    }

    public boolean isSkipSerialization() {
        return skipSerialization;
    }

    public void setSkipSerialization(boolean skipSerialization) {
        this.skipSerialization = skipSerialization;
    }
    
}
