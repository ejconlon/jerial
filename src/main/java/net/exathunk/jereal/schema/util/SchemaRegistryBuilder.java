package net.exathunk.jereal.schema.util;

import net.exathunk.jereal.base.jerializers.RegistryBuilder;
import net.exathunk.jereal.base.jerializers.RegistryFactory;
import net.exathunk.jereal.schema.domain.Link;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import net.exathunk.jereal.schema.jerializers.*;

/**
 * charolastra 10/27/12 3:33 PM
 */
public class SchemaRegistryBuilder extends RegistryBuilder {

    public SchemaRegistryBuilder() {
        add(Schema.class, new SchemaJerializer(), new SchemaDejerializer());
        add(Link.class, new LinkJerializer(), new LinkDejerializer());
        add(SchemaRef.class, new SchemaRefJerializer());
    }

}
