package net.exathunk.jereal.schema;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

/**
 * charolastra 10/28/12 8:12 PM
 */
public class RefRegistry<T> {

    private final Map<T, Schema> refMap;

    public RefRegistry() {
        refMap = new HashMap<T, Schema>();
    }

    public boolean knowsRef(T ref) {
        return refMap.containsKey(ref);
    }

    public void addRef(T ref, Schema schema) {
        refMap.put(ref, schema);
    }

    public Schema getRef(T ref) {
        return refMap.get(ref);
    }

    public void subsume(Schema schema) {
        // TODO
        throw new NotImplementedException();
    }
}
