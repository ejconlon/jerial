package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.schema.domain.Link;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Schema> {

    private static <V> Ref<V> ref(V v) { return new RefImpl<V>(v); }

    @Override
    public Schema prototype(Speclike spec) {
        return new Schema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Schema schema) throws JerializerException {
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
        objectDSL.seeWritable("default", ref(recurser.seeThing(dsl, schema.defaultz)));

        objectDSL.seeBoolean("required", schema.required);
        objectDSL.seeBoolean("uniqueItems", schema.uniqueItems);

        objectDSL.seeLong("minItems", schema.minItems);
        objectDSL.seeLong("minimum", schema.minimum);

        objectDSL.seeWritable("additionalProperties", ref(recurser.seeCustom(dsl, schema.additionalProperties_SchemaRef, SchemaRef.class)));
        objectDSL.seeBoolean("additionalProperties", schema.additionalProperties_Boolean);

        objectDSL.seeWritable("type", ref(recurser.seeCustomList(dsl, schema.type_SchemaRef, SchemaRef.class)));
        objectDSL.seeString("type", schema.type_String);

        objectDSL.seeWritable("items", ref(recurser.seeCustom(dsl, schema.items, SchemaRef.class)));

        objectDSL.seeWritable("extends", ref(recurser.seeCustom(dsl, schema.extendz, SchemaRef.class)));

        objectDSL.seeWritable("properties", ref(recurser.seeCustomMap(dsl, schema.properties, SchemaRef.class)));

        objectDSL.seeWritable("dependencies", ref(recurser.seeSimpleMap(dsl, schema.dependencies)));

        objectDSL.seeWritable("links", ref(recurser.seeCustomList(dsl, schema.links, Link.class)));

        return objectDSL;
    }
}
