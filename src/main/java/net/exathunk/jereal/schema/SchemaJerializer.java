package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer implements Jerializer<Schema> {
    @Override
    public void jerialize(JerializerRegistry registry, Schema schema, JerialContext context) throws JerializerException {
        Jerializer<Link> linkJerializer = registry.getJerializer(Link.class);

        JDSL.addString("id", schema.id, context);
        JDSL.addString("name", schema.name, context);
        JDSL.addString("description", schema.description, context);
        JDSL.addString("title", schema.title, context);
        JDSL.addString("format", schema.format, context);
        JDSL.addString("$ref", schema.dollar_ref, context);
        JDSL.addString("$schema", schema.dollar_schema, context);
        JDSL.addString("fragmentResolution", schema.fragmentResolution, context);

        // Unparsed item
        if (schema.defaultz != null) {
            context.builder.addThing(PathPart.key("default"), schema.defaultz);
        }

        JDSL.addBoolean("required", schema.required, context);
        JDSL.addBoolean("uniqueItems", schema.uniqueItems, context);

        JDSL.addLong("minItems", schema.minItems, context);
        JDSL.addLong("minimum", schema.minimum, context);

        JDSL.add(registry, PathPart.key("additionalProperties"), schema.additionalProperties, context);

        if (!schema.type.isEmpty()) JDSL.addSinglyList(registry, PathPart.key("type"), schema.type, context);

        JDSL.add(registry, PathPart.key("items"), schema.items, context);

        JDSL.add(registry, PathPart.key("extends"), schema.extendz, context);

        if (!schema.properties.isEmpty()) JDSL.addMap(registry, PathPart.key("properties"), schema.properties, context);

        if (!schema.dependencies.isEmpty()) JDSL.addMap(registry, PathPart.key("dependencies"), schema.dependencies, context);

        if (!schema.links.isEmpty()) JDSL.addList(registry, PathPart.key("links"), schema.links, context);
    }

}
