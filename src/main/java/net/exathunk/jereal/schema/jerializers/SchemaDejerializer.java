package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.Dejerializer;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.schema.domain.SchemaRef;
import net.exathunk.jereal.schema.domain.Link;
import net.exathunk.jereal.schema.domain.Schema;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 2:00 PM
 */
public class SchemaDejerializer implements Dejerializer<Schema> {
    @Override
    public void dejerialize(DejerializerRegistry registry, JObject object, Schema schema) throws JerializerException {
        Dejerializer<Link> linkDejerializer = registry.getDejerializer(Link.class);
        for (Map.Entry<String, JThing> item : object.seq()) {
            final String key = item.getKey();
            final JThing value = item.getValue();
            if ("dependencies".equals(key)) {
                // TODO assert types
                for (Map.Entry<String, JThing> dep : value.rawGetObject().seq()) {
                    schema.dependencies.put(dep.getKey(), dep.getValue().rawGetString().runResFunc());
                }
            } else if ("properties".equals(key)) {
                for (Map.Entry<String, JThing> propEntry : value.rawGetObject().seq()) {
                    // TODO assert types
                    final String propKey = propEntry.getKey();
                    final JThing propValue = propEntry.getValue();
                    if (propValue.isString()) {
                        schema.properties.put(propKey, SchemaRef.makeRef(propValue.rawGetString().runResFunc()));
                    } else if (propValue.isObject()) {
                        Schema propSchema = new Schema();
                        dejerialize(registry, propValue.rawGetObject(), propSchema);
                        schema.properties.put(propKey, SchemaRef.<String>makeSchema(propSchema));
                    } else {
                        throw new JerializerException("Unexpected property: "+propEntry);
                    }
                }
            } else if ("links".equals(key)) {
                for (Map.Entry<Integer, JThing> linkItem : value.rawGetArray().seq()) {
                    Link link = new Link();
                    linkDejerializer.dejerialize(registry, linkItem.getValue().rawGetObject(), link);
                    schema.links.add(link);
                }
            } else if ("name".equals(key)) {
                schema.name = value.rawGetString().runResFunc();
            } else if ("description".equals(key)) {
                schema.description = value.rawGetString().runResFunc();
            } else if ("title".equals(key)) {
                schema.title = value.rawGetString().runResFunc();
            } else if ("format".equals(key)) {
                schema.format = value.rawGetString().runResFunc();
            } else if ("required".equals(key)) {
                schema.required = value.rawGetBoolean().runResFunc();
            } else if ("uniqueItems".equals(key)) {
                schema.uniqueItems = value.rawGetBoolean().runResFunc();
            } else if ("minItems".equals(key)) {
                schema.minItems = value.rawGetLong().runResFunc();
            } else if ("minimum".equals(key)) {
                schema.minimum = value.rawGetLong().runResFunc();
            } else if ("type".equals(key)) {
                addTypes(registry, value, schema.type);
            } else if ("items".equals(key)) {
                if (value.isString()) {
                    schema.items = SchemaRef.makeRef(value.rawGetString().runResFunc());
                } else {
                    Schema s = new Schema();
                    registry.getDejerializer(Schema.class).dejerialize(registry, value.rawGetObject(), s);
                    schema.items = SchemaRef.<String>makeSchema(s);
                }
            } else if ("$ref".equals(key)) {
                schema.dollar_ref = value.rawGetString().runResFunc();
            } else if ("$schema".equals(key)) {
                schema.dollar_schema = value.rawGetString().runResFunc();
            } else if ("extends".equals(key)) {
                if (value.isString()) {
                    schema.extendz = SchemaRef.makeRef(value.rawGetString().runResFunc());
                } else if (value.isObject()) {
                    Schema s = new Schema();
                    registry.getDejerializer(Schema.class).dejerialize(registry, value.rawGetObject(), s);
                    schema.extendz = SchemaRef.makeSchema(s);
                } else {
                    throw new JerializerException("Unhandled extends: "+item);
                }
            } else if ("fragmentResolution".equals(key)) {
                schema.fragmentResolution = value.rawGetString().runResFunc();
            } else if ("id".equals(key)) {
                schema.id = value.rawGetString().runResFunc();
            } else if ("default".equals(key)) {
                schema.defaultz = value;
            } else if ("additionalProperties".equals(key)) {
                if (value.isString()) {
                    schema.additionalProperties = Either.makeLeft(SchemaRef.makeRef(value.rawGetString().runResFunc()));
                } else if (value.isBoolean()) {
                    schema.additionalProperties = Either.makeRight(value.rawGetBoolean().runResFunc());
                } else if (value.isObject()) {
                    Schema s = new Schema();
                    dejerialize(registry, value.rawGetObject(), s);
                    schema.additionalProperties = Either.makeLeft(SchemaRef.<String>makeSchema(s));
                } else {
                    throw new JerializerException("Unhandled additionalProperties: "+item);
                }
            } else {
                throw new JerializerException("Unexpected: "+item);
            }
        }
    }

    private void addTypes(DejerializerRegistry registry, JThing item, List<SchemaRef<Schema.TYPE>> types) throws JerializerException{
        if (item.isArray()) {
            for (Map.Entry<Integer, JThing> child : item.rawGetArray().seq()) {
                addTypes(registry, child.getValue(), types);
            }
        } else if (item.isString()) {
            types.add(SchemaRef.makeRef(Schema.TYPE.fromString(item.rawGetString().runResFunc())));
        } else if (item.isObject()) {
            Schema s = new Schema();
            dejerialize(registry, item.rawGetObject(), s);
            types.add(SchemaRef.<Schema.TYPE>makeSchema(s));
        } else {
            throw new JerializerException("Bad type format: "+item);
        }
    }
}
