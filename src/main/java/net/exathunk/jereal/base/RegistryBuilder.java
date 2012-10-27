package net.exathunk.jereal.base;

/**
 * charolastra 10/27/12 3:38 PM
 */
public class RegistryBuilder implements RegistryFactory {

    private final JerializerRegistryImpl jerializerRegistry = new JerializerRegistryImpl();
    private final DejerializerRegistryImpl dejerializerRegistry = new DejerializerRegistryImpl();

    protected <T> void add(Class<T> key, Jerializer<T> jerializer, Dejerializer<T> dejerializer) {
        jerializerRegistry.addJerializer(key, jerializer);
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
