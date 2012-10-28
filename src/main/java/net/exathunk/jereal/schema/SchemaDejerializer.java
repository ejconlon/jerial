package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.jerializers.Dejerializer;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.List;

/**
 * charolastra 10/27/12 2:00 PM
 */
public class SchemaDejerializer implements Dejerializer<Schema> {
    @Override
    public void dejerialize(DejerializerRegistry registry, Jerial Jerial, Schema schema) throws JerializerException {
        Dejerializer<Link> linkDejerializer = registry.getDejerializer(Link.class);
        for (Jitem item : Jerial) {
            final PathPart part = item.getPart();
            if (part.hasRight()) throw new JerializerException("Unexpected array elt: "+part);
            else {
                final String key = part.getLeft();
                if ("dependencies".equals(key)) {
                    for (Jitem dep : item.getObject()) {
                        schema.dependencies.put(dep.getPart().getLeft(), dep.getString());
                    }
                } else if ("properties".equals(key)) {
                    for (Jitem prop : item.getObject()) {
                        if (prop.isString()) {
                            schema.properties.put(prop.getPart().getLeft(), SchemaRef.makeRef(prop.getString()));
                        } else if (prop.isObject()) {
                            Schema propSchema = new Schema();
                            dejerialize(registry, prop.getObject(), propSchema);
                            schema.properties.put(prop.getPart().getLeft(), SchemaRef.<String>makeSchema(propSchema));
                        } else {
                            throw new JerializerException("Unexpected property: "+prop);
                        }
                    }
                } else if ("links".equals(key)) {
                    for (Jitem linkItem : item.getArray()) {
                        Link link = new Link();
                        linkDejerializer.dejerialize(registry, linkItem.getObject(), link);
                        schema.links.add(link);
                    }
                } else if ("name".equals(key)) {
                    schema.name = item.getString();
                } else if ("description".equals(key)) {
                    schema.description = item.getString();
                } else if ("title".equals(key)) {
                    schema.title = item.getString();
                } else if ("format".equals(key)) {
                    schema.format = item.getString();
                } else if ("required".equals(key)) {
                    schema.required = item.getBoolean();
                } else if ("uniqueItems".equals(key)) {
                    schema.uniqueItems = item.getBoolean();
                } else if ("minItems".equals(key)) {
                    schema.minItems = item.getLong();
                } else if ("minimum".equals(key)) {
                    schema.minimum = item.getLong();
                } else if ("type".equals(key)) {
                    addTypes(registry, item, schema.type);
                } else if ("items".equals(key)) {
                    if (item.isString()) {
                        schema.items = SchemaRef.makeRef(item.getString());
                    } else {
                        Schema s = new Schema();
                        registry.getDejerializer(Schema.class).dejerialize(registry, item.getObject(), s);
                        schema.items = SchemaRef.<String>makeSchema(s);
                    }
                } else if ("$ref".equals(key)) {
                    schema.dollar_ref = item.getString();
                } else if ("$schema".equals(key)) {
                    schema.dollar_schema = item.getString();
                } else if ("extends".equals(key)) {
                    if (item.isString()) {
                        schema.extendz = SchemaRef.makeRef(item.getString());
                    } else if (item.isObject()) {
                        Schema s = new Schema();
                        registry.getDejerializer(Schema.class).dejerialize(registry, item.getObject(), s);
                        schema.extendz = SchemaRef.makeSchema(s);
                    } else {
                        throw new JerializerException("Unhandled extends: "+item);
                    }
                } else if ("fragmentResolution".equals(key)) {
                    schema.fragmentResolution = item.getString();
                } else if ("id".equals(key)) {
                    schema.id = item.getString();
                } else if ("default".equals(key)) {
                    schema.defaultz = item;
                } else if ("additionalProperties".equals(key)) {
                    if (item.isString()) {
                        schema.additionalProperties = Either.makeLeft(SchemaRef.makeRef(item.getString()));
                    } else if (item.isBoolean()) {
                        schema.additionalProperties = Either.makeRight(item.getBoolean());
                    } else if (item.isObject()) {
                        Schema s = new Schema();
                        dejerialize(registry, item.getObject(), s);
                        schema.additionalProperties = Either.makeLeft(SchemaRef.<String>makeSchema(s));
                    } else {
                        throw new JerializerException("Unhandled additionalProperties: "+item);
                    }
                } else {
                    throw new JerializerException("Unexpected: "+item);
                }
            }
        }
    }

    private void addTypes(DejerializerRegistry registry, Jitem item, List<SchemaRef<Schema.TYPE>> types) throws JerializerException{
        if (item.isArray()) {
            for (Jitem child : item.getArray()) {
                addTypes(registry, child, types);
            }
        } else if (item.isString()) {
            types.add(SchemaRef.makeRef(Schema.TYPE.fromString(item.getString())));
        } else if (item.isObject()) {
            Schema s = new Schema();
            dejerialize(registry, item.getObject(), s);
            types.add(SchemaRef.<Schema.TYPE>makeSchema(s));
        } else {
            throw new JerializerException("Bad type format: "+item);
        }
    }
}
