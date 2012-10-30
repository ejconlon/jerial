package net.exathunk.jereal.schema.util;

import net.exathunk.jereal.base.jerializers.RegistryBuilder;
import net.exathunk.jereal.base.jerializers.RegistryFactory;
import net.exathunk.jereal.schema.domain.Link;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.jerializers.LinkDejerializer;
import net.exathunk.jereal.schema.jerializers.LinkJerializer;
import net.exathunk.jereal.schema.jerializers.SchemaDejerializer;
import net.exathunk.jereal.schema.jerializers.SchemaJerializer;

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
