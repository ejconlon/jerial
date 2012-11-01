package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;

import java.util.HashMap;
import java.util.Map;

/**
 * charolastra 10/27/12 3:12 PM
 */
public class JerializerRegistryImpl<T extends PushableContext<T, U>, U> implements JerializerRegistry<T, U> {
    private final Map<Class, Jerializer> registry = new HashMap<Class, Jerializer>();

    public <V> void addJerializer(Class<T> key, Jerializer<T, U, V> value) {
        registry.put(key, value);
    }

    @Override
    public <V> boolean hasJerializer(Class<V> key) {
        return registry.containsKey(key);
    }

    @Override
    public <V> Jerializer<T, U, V> getJerializer(Class<V> key) throws JerializerException {
        if (registry.containsKey(key)) {
            return registry.get(key);
        } else {
            throw new JerializerException("Cannot find jerializer for class "+key);
        }
    }
}
