package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;

/**
 * charolastra 10/27/12 3:38 PM
 */
public class RegistryBuilder<T extends PushableContext<T, U>, U extends Questionable> implements RegistryFactory<T, U> {

    private final JerializerRegistryImpl jerializerRegistry = new JerializerRegistryImpl();

    protected <V> void add(Class<V> key, Jerializer<T, U, V> jerializer) {
        jerializerRegistry.addJerializer(key, jerializer);
    }

    @Override
    public JerializerRegistry<T, U> makeJerializerRegistry() {
        return jerializerRegistry;
    }
}
