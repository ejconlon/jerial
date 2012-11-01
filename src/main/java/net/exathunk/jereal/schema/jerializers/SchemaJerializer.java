package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.schema.domain.Schema;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Schema> {
    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Schema schema) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();

        objectDSL.seeString("id", schema.id);
        objectDSL.seeString("name", schema.name);
        objectDSL.seeString("description", schema.description);
        objectDSL.seeString("title", schema.title);
        objectDSL.seeString("format", schema.format);
        objectDSL.seeString("$ref", schema.dollar_ref);
        objectDSL.seeString("$schema", schema.dollar_schema);
        objectDSL.seeString("fragmentResolution", schema.fragmentResolution);

        // Unparsed item
        objectDSL.seeWritable("default", recurser.seeThing(dsl, schema.defaultz));

        objectDSL.seeBoolean("required", schema.required);
        objectDSL.seeBoolean("uniqueItems", schema.uniqueItems);

        objectDSL.seeLong("minItems", schema.minItems);
        objectDSL.seeLong("minimum", schema.minimum);

        objectDSL.seeWritable("additionalProperties", recurser.seeCustom(dsl, schema.additionalProperties_SchemaRef));
        objectDSL.seeBoolean("additionalProperties", schema.additionalProperties_Boolean);

        objectDSL.seeWritable("type", recurser.seeCustomList(dsl, schema.type_SchemaRef));
        objectDSL.seeString("type", schema.type_String);

        objectDSL.seeWritable("items", recurser.seeCustom(dsl, schema.items));

        objectDSL.seeWritable("extends", recurser.seeCustom(dsl, schema.extendz));

        objectDSL.seeWritable("properties", recurser.seeCustomMap(dsl, schema.properties));

        objectDSL.seeWritable("dependencies", recurser.seeSimpleMap(dsl, schema.dependencies));

        objectDSL.seeWritable("links", recurser.seeCustomList(dsl, schema.links));

        return objectDSL;
    }
}
