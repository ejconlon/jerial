package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer implements Jerializer<Schema> {
    @Override
    public void jerialize(JerializerRegistry registry, Schema schema, JerialContext context) throws JerializerException {
        if (schema.name != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("name"), schema.name));
        if (schema.description != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("description"), schema.description));
        if (schema.title != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("title"), schema.title));
        if (schema.format != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("format"), schema.format));
        if (schema.dollar_ref != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("$ref"), schema.dollar_ref));
        if (schema.dollar_schema != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("$schema"), schema.dollar_schema));
        if (schema.required) context.builder.addJitem(Jitem.makeBoolean(PathPart.makeLeft("required"), schema.required));
        if (!schema.type.isEmpty()) {
            addTypes(schema.type, "type", context);
        }
        if (schema.items != null) {
            final PathPart part = PathPart.makeLeft("items");
            JerialContext newContext = context.push(part);
            registry.getJerializer(Schema.class).jerialize(registry, schema.items, newContext);
            context.builder.addJitem(Jitem.makeObject(part, newContext.builder.buildJerial()));
        }
        if (!schema.properties.isEmpty()) {
            final PathPart parentPart = PathPart.makeLeft("properties");
            JerialContext parentContext = context.push(parentPart);
            for (Map.Entry<String, Schema> props : schema.properties.entrySet()) {
                final PathPart part = PathPart.makeLeft(props.getKey());
                JerialContext childContext = parentContext.push(part);
                jerialize(registry, props.getValue(), childContext);
                parentContext.builder.addJitem(Jitem.makeObject(part, childContext.builder.buildJerial()));
            }
            context.builder.addJitem(Jitem.makeObject(parentPart, parentContext.builder.buildJerial()));
        }
        if (!schema.dependencies.isEmpty()) {
            final PathPart parentPart = PathPart.makeLeft("dependencies");
            JerialContext parentContext = context.push(parentPart);
            for (Map.Entry<String, String> deps : schema.dependencies.entrySet()) {
                final PathPart part = PathPart.makeLeft(deps.getKey());
                parentContext.builder.addJitem(Jitem.makeString(part, deps.getValue()));
            }
            context.builder.addJitem(Jitem.makeObject(parentPart, parentContext.builder.buildJerial()));
        }
        //throw new JerializerException("TODO");
    }


    private static void addTypes(List<Schema.TYPE> types, String key, JerialContext context) {
        assert (types.size() > 0);
        List<Jitem> arr = new ArrayList<Jitem>(types.size());
        for (int i = 0; i < types.size(); ++i) {
            arr.add(Jitem.makeString(PathPart.makeRight(i), types.get(i).name().toLowerCase()));
        }
        if (arr.size() == 1) {
            context.builder.addJitem(Jitem.makeString(PathPart.makeLeft(key), arr.get(0).getString()));
        } else {
            context.builder.addJitem(Jitem.makeArray(PathPart.makeLeft(key), arr));
        }
    }
}
