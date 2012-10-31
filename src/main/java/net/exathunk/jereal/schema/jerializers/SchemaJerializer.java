package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.schema.domain.Schema;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer implements Jerializer<Schema> {
    @Override
    public void jerialize(JDSL jdsl, Schema schema) throws JerializerException {
        jdsl.addString("id", schema.id);
        jdsl.addString("name", schema.name);
        jdsl.addString("description", schema.description);
        jdsl.addString("title", schema.title);
        jdsl.addString("format", schema.format);
        jdsl.addString("$ref", schema.dollar_ref);
        jdsl.addString("$schema", schema.dollar_schema);
        jdsl.addString("fragmentResolution", schema.fragmentResolution);

        // Unparsed item
        jdsl.addThing(PathPart.key("default"), schema.defaultz);

        jdsl.addBoolean("required", schema.required);
        jdsl.addBoolean("uniqueItems", schema.uniqueItems);

        jdsl.addLong("minItems", schema.minItems);
        jdsl.addLong("minimum", schema.minimum);

        jdsl.add(PathPart.key("additionalProperties"), schema.additionalProperties);

        jdsl.addSinglyList(PathPart.key("type"), schema.type);

        jdsl.add(PathPart.key("items"), schema.items);

        jdsl.add(PathPart.key("extends"), schema.extendz);

        jdsl.addMap(PathPart.key("properties"), schema.properties);

        jdsl.addMap(PathPart.key("dependencies"), schema.dependencies);

        jdsl.addList(PathPart.key("links"), schema.links);
    }
}
