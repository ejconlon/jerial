package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.JerializerException;

import java.util.HashMap;
import java.util.Map;

/**
 * charolastra 10/27/12 3:12 PM
 */
public class JerializerRegistryImpl implements JerializerRegistry {
    private final Map<Class, Jerializer> registry = new HashMap<Class, Jerializer>();

    public <T> void addJerializer(Class<T> key, Jerializer<T> value) {
        registry.put(key, value);
    }

    @Override
    public <T> boolean hasJerializer(Class<T> key) {
        return registry.containsKey(key);
    }

    @Override
    public <T> Jerializer<T> getJerializer(Class<T> key) throws JerializerException {
        if (registry.containsKey(key)) {
            return registry.get(key);
        } else {
            throw new JerializerException("Cannot find jerializer for class "+key);
        }
    }
}
