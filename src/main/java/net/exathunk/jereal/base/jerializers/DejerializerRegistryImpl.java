package net.exathunk.jereal.base.jerializers;

import java.util.HashMap;
import java.util.Map;

/**
 * charolastra 10/27/12 3:12 PM
 */
public class DejerializerRegistryImpl implements DejerializerRegistry {
    private final Map<Class, Dejerializer> registry = new HashMap<Class, Dejerializer>();

    public <T> void addDejerializer(Class<T> key, Dejerializer<T> value) {
        registry.put(key, value);
    }

    @Override
    public <T> boolean hasDejerializer(Class<T> key) {
        return registry.containsKey(key);
    }

    @Override
    public <T> Dejerializer<T> getDejerializer(Class<T> key) throws JerializerException {
        if (registry.containsKey(key)) {
            return registry.get(key);
        } else {
            throw new JerializerException("Cannot find jerializer for class "+key);
        }
    }
}
