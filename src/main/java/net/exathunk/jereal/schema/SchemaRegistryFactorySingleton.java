package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.RegistryBuilder;
import net.exathunk.jereal.base.RegistryFactory;

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
        add(Meta.class, new MetaJerializer(), new MetaDejerializer());
    }

}
