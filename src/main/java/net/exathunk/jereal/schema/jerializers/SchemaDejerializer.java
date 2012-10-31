package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
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
                    schema.dependencies.getRef().put(dep.getKey(), dep.getValue().rawGetString().getRef());
                }
            } else if ("properties".equals(key)) {
                for (Map.Entry<String, JThing> propEntry : value.rawGetObject().seq()) {
                    // TODO assert types
                    final String propKey = propEntry.getKey();
                    final JThing propValue = propEntry.getValue();
                    if (propValue.isString()) {
                        schema.properties.getRef().put(propKey, SchemaRef.makeRef(propValue.rawGetString().getRef()));
                    } else if (propValue.isObject()) {
                        Schema propSchema = new Schema();
                        dejerialize(registry, propValue.rawGetObject(), propSchema);
                        schema.properties.getRef().put(propKey, SchemaRef.makeSchema(propSchema));
                    } else {
                        throw new JerializerException("Unexpected property: "+propEntry);
                    }
                }
            } else if ("links".equals(key)) {
                for (Map.Entry<Integer, JThing> linkItem : value.rawGetArray().seq()) {
                    Link link = new Link();
                    linkDejerializer.dejerialize(registry, linkItem.getValue().rawGetObject(), link);
                    schema.links.getRef().add(link);
                }
            } else if ("name".equals(key)) {
                schema.name.setRef(value.rawGetString().getRef());
            } else if ("description".equals(key)) {
                schema.description.setRef(value.rawGetString().getRef());
            } else if ("title".equals(key)) {
                schema.title.setRef(value.rawGetString().getRef());
            } else if ("format".equals(key)) {
                schema.format.setRef(value.rawGetString().getRef());
            } else if ("required".equals(key)) {
                schema.required.setRef(value.rawGetBoolean().getRef());
            } else if ("uniqueItems".equals(key)) {
                schema.uniqueItems.setRef(value.rawGetBoolean().getRef());
            } else if ("minItems".equals(key)) {
                schema.minItems.setRef(value.rawGetLong().getRef());
            } else if ("minimum".equals(key)) {
                schema.minimum.setRef(value.rawGetLong().getRef());
            } else if ("type".equals(key)) {
                addTypes(registry, value, schema.type);
            } else if ("items".equals(key)) {
                if (value.isString()) {
                    schema.items.setRef(SchemaRef.makeRef(value.rawGetString().getRef()));
                } else {
                    Schema s = new Schema();
                    registry.getDejerializer(Schema.class).dejerialize(registry, value.rawGetObject(), s);
                    schema.items.setRef(SchemaRef.makeSchema(s));
                }
            } else if ("$ref".equals(key)) {
                schema.dollar_ref.setRef(value.rawGetString().getRef());
            } else if ("$schema".equals(key)) {
                schema.dollar_schema.setRef(value.rawGetString().getRef());
            } else if ("extends".equals(key)) {
                if (value.isString()) {
                    schema.extendz.setRef(SchemaRef.makeRef(value.rawGetString().getRef()));
                } else if (value.isObject()) {
                    Schema s = new Schema();
                    registry.getDejerializer(Schema.class).dejerialize(registry, value.rawGetObject(), s);
                    schema.extendz.setRef(SchemaRef.makeSchema(s));
                } else {
                    throw new JerializerException("Unhandled extends: "+item);
                }
            } else if ("fragmentResolution".equals(key)) {
                schema.fragmentResolution.setRef(value.rawGetString().getRef());
            } else if ("id".equals(key)) {
                schema.id.setRef(value.rawGetString().getRef());
            } else if ("default".equals(key)) {
                schema.defaultz.setRef(value);
            } else if ("additionalProperties".equals(key)) {
                if (value.isString()) {
                    Either<SchemaRef, Boolean> foo = Either.<SchemaRef, Boolean>makeLeft(SchemaRef.makeRef(value.rawGetString().getRef()));
                    schema.additionalProperties.setRef(foo);
                } else if (value.isBoolean()) {
                    schema.additionalProperties.setRef(Either.<SchemaRef, Boolean>makeRight(value.rawGetBoolean().getRef()));
                } else if (value.isObject()) {
                    Schema s = new Schema();
                    dejerialize(registry, value.rawGetObject(), s);
                    schema.additionalProperties.setRef(Either.<SchemaRef, Boolean>makeLeft(SchemaRef.makeSchema(s)));
                } else {
                    throw new JerializerException("Unhandled additionalProperties: "+item);
                }
            } else {
                throw new JerializerException("Unexpected: "+item);
            }
        }
    }

    private void addTypes(DejerializerRegistry registry, JThing item, Ref<List<SchemaRef>> types) throws JerializerException{
        if (item.isArray()) {
            for (Map.Entry<Integer, JThing> child : item.rawGetArray().seq()) {
                addTypes(registry, child.getValue(), types);
            }
        } else if (item.isString()) {
            final String s = item.rawGetString().getRef();
            final SchemaRef r = SchemaRef.makeRef(s);
            types.getRef().add(r);
        } else if (item.isObject()) {
            Schema s = new Schema();
            dejerialize(registry, item.rawGetObject(), s);
            types.getRef().add(SchemaRef.makeSchema(s));
        } else {
            throw new JerializerException("Bad type format: "+item);
        }
    }
}
