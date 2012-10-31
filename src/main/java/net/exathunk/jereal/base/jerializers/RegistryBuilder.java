package net.exathunk.jereal.base.jerializers;

/**
 * charolastra 10/27/12 3:38 PM
 */
public class RegistryBuilder<C> implements RegistryFactory {

    private final JerializerRegistryImpl jerializerRegistry = new JerializerRegistryImpl();
    private final DejerializerRegistryImpl dejerializerRegistry = new DejerializerRegistryImpl();

    protected <T> void add(Class<T> key, Jerializer<T, C> jerializer, Dejerializer<T> dejerializer) {
        add(key, jerializer);
        add(key, dejerializer);
    }

    protected <T> void add(Class<T> key, Jerializer<T, C> jerializer) {
        jerializerRegistry.addJerializer(key, jerializer);
    }

    protected <T> void add(Class<T> key, Dejerializer<T> dejerializer) {
        dejerializerRegistry.addDejerializer(key, dejerializer);
    }

    @Override
    public JerializerRegistry makeJerializerRegistry() {
        return jerializerRegistry;
    }

    @Override
    public DejerializerRegistry makeDejerializerRegistry() {
        return dejerializerRegistry;
    }
}
