package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.schema.domain.Schema;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Schema> {
    @Override
    public void jerialize(Recurser<T, U> recurser, ObjectDSL<T, U> dsl, Schema schema) throws JerializerException {
        dsl.seeString("id", schema.id);
        dsl.seeString("name", schema.name);
        dsl.seeString("description", schema.description);
        dsl.seeString("title", schema.title);
        dsl.seeString("format", schema.format);
        dsl.seeString("$ref", schema.dollar_ref);
        dsl.seeString("$schema", schema.dollar_schema);
        dsl.seeString("fragmentResolution", schema.fragmentResolution);

        // Unparsed item
        recurser.seeThing(dsl, "default", schema.defaultz);

        dsl.seeBoolean("required", schema.required);
        dsl.seeBoolean("uniqueItems", schema.uniqueItems);

        dsl.seeLong("minItems", schema.minItems);
        dsl.seeLong("minimum", schema.minimum);

        recurser.seeCustom(dsl, "additionalProperties", schema.additionalProperties_SchemaRef);
        dsl.seeBoolean("additionalProperties", schema.additionalProperties_Boolean);

        recurser.seeCustomList(dsl, "type", schema.type_SchemaRef);
        dsl.seeString("type", schema.type_String);

        recurser.seeCustom(dsl, "items", schema.items);

        recurser.seeCustom(dsl, "extends", schema.extendz);

        recurser.seeCustomMap(dsl, "properties", schema.properties);

        recurser.seeSimpleMap(dsl, "dependencies", schema.dependencies);

        recurser.seeCustomList(dsl, "links", schema.links);
    }
}
