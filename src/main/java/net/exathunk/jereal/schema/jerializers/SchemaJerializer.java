package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.schema.domain.Schema;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer implements Jerializer<Schema> {
    @Override
    public void jerialize(JerializerRegistry registry, Schema schema, JerialContext context) throws JerializerException {
        JDSL jdsl = new JDSLImpl();
        jdsl.addString("id", schema.id, context);
        jdsl.addString("name", schema.name, context);
        jdsl.addString("description", schema.description, context);
        jdsl.addString("title", schema.title, context);
        jdsl.addString("format", schema.format, context);
        jdsl.addString("$ref", schema.dollar_ref, context);
        jdsl.addString("$schema", schema.dollar_schema, context);
        jdsl.addString("fragmentResolution", schema.fragmentResolution, context);

        // Unparsed item
        jdsl.addThing("default", schema.defaultz, context);

        jdsl.addBoolean("required", schema.required, context);
        jdsl.addBoolean("uniqueItems", schema.uniqueItems, context);

        jdsl.addLong("minItems", schema.minItems, context);
        jdsl.addLong("minimum", schema.minimum, context);

        jdsl.add(registry, PathPart.key("additionalProperties"), schema.additionalProperties, context);

        jdsl.addSinglyList(registry, PathPart.key("type"), schema.type, context);

        jdsl.add(registry, PathPart.key("items"), schema.items, context);

        jdsl.add(registry, PathPart.key("extends"), schema.extendz, context);

        jdsl.addMap(registry, PathPart.key("properties"), schema.properties, context);

        jdsl.addMap(registry, PathPart.key("dependencies"), schema.dependencies, context);

        jdsl.addList(registry, PathPart.key("links"), schema.links, context);
    }

}
