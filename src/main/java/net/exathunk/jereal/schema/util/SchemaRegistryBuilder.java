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
 * charolastra 10/27/12 3:33 PM
 */
public class SchemaRegistryBuilder<C> extends RegistryBuilder<C> {

    public SchemaRegistryBuilder() {
        add(Schema.class, new SchemaJerializer<C>(), new SchemaDejerializer());
        add(Link.class, new LinkJerializer<C>(), new LinkDejerializer());
    }

}
