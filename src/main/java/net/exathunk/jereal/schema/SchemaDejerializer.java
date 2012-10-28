package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.Dejerializer;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.DejerializerRegistry;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.List;

/**
 * charolastra 10/27/12 2:00 PM
 */
public class SchemaDejerializer implements Dejerializer<Schema> {
    @Override
    public void dejerialize(DejerializerRegistry registry, Jerial jerial, Schema schema) throws JerializerException {
        for (Jitem item : jerial) {
            final PathPart part = item.getPart();
            if (part.hasRight()) throw new JerializerException("Unexpected array elt");
            else {
                final String key = part.getLeft();
                if ("dependencies".equals(key)) {
                    for (Jitem dep : item.getObject()) {
                        schema.dependencies.put(dep.getPart().getLeft(), dep.getString());
                    }
                } else if ("properties".equals(key)) {
                    for (Jitem prop : item.getObject()) {
                        Schema propSchema = new Schema();
                        dejerialize(registry, prop.getObject(), propSchema);
                        schema.properties.put(prop.getPart().getLeft(), propSchema);
                    }
                } else if ("links".equals(key)) {
                    throw new JerializerException("TODO");
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
                } else if ("type".equals(key)) {
                    addTypes(item, schema.type);
                } else if ("items".equals(key)) {
                    schema.items = new Schema();
                    registry.getDejerializer(Schema.class).dejerialize(registry, item.getObject(), schema.items);
                } else if ("$ref".equals(key)) {
                    schema.dollar_ref = item.getString();
                } else if ("$schema".equals(key)) {
                    schema.dollar_schema = item.getString();
                } else {
                    throw new JerializerException("Unexpected part: "+item.getPart());
                }
            }
        }
    }

    private static void addTypes(Jitem item, List<Schema.TYPE> types) throws JerializerException{
        if (item.isArray()) {
            for (Jitem child : item.getArray()) {
                types.add(Schema.TYPE.valueOf(child.getString().toUpperCase()));
            }
        } else if (item.isString()) {
            types.add(Schema.TYPE.valueOf(item.getString().toUpperCase()));
        } else {
            throw new JerializerException("Bad type format: "+item);
        }
    }
}
