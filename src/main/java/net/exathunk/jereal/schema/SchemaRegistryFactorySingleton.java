package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.jerializers.RegistryBuilder;
import net.exathunk.jereal.base.jerializers.RegistryFactory;

/**
 * Horribly accurate name.
 *
 * charolastra 10/27/12 3:33 PM
 */
public class SchemaRegistryFactorySingleton extends RegistryBuilder {

    private static final SchemaRegistryFactorySingleton INSTANCE = new SchemaRegistryFactorySingleton();

    public static RegistryFactory getInstance() {
        return INSTANCE;
    }

    private SchemaRegistryFactorySingleton() {
        add(Schema.class, new SchemaJerializer(), new SchemaDejerializer());
        add(Link.class, new LinkJerializer(), new LinkDejerializer());
    }

}
