package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;

/**
 * charolastra 10/27/12 3:38 PM
 */
public class RegistryBuilder<T extends PushableContext<T, U>, U> implements RegistryFactory<T, U> {

    private final JerializerRegistryImpl jerializerRegistry = new JerializerRegistryImpl();
    private final DejerializerRegistryImpl dejerializerRegistry = new DejerializerRegistryImpl();

    protected <V> void add(Class<V> key, Jerializer<T, U, V> jerializer, Dejerializer<V> dejerializer) {
        add(key, jerializer);
        add(key, dejerializer);
    }

    protected <V> void add(Class<V> key, Jerializer<T, U, V> jerializer) {
        jerializerRegistry.addJerializer(key, jerializer);
    }

    protected <V> void add(Class<V> key, Dejerializer<V> dejerializer) {
        dejerializerRegistry.addDejerializer(key, dejerializer);
    }

    @Override
    public JerializerRegistry<T, U> makeJerializerRegistry() {
        return jerializerRegistry;
    }

    @Override
    public DejerializerRegistry makeDejerializerRegistry() {
        return dejerializerRegistry;
    }
}
