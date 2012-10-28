package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.Map;

/**
 * charolastra 10/27/12 3:06 PM
 */
public class SchemaJerializer implements Jerializer<Schema> {
    @Override
    public void jerialize(JerializerRegistry registry, Schema schema, JerialContext context) throws JerializerException {
        Jerializer<Meta> metaJerializer = registry.getJerializer(Meta.class);
        metaJerializer.jerialize(registry, schema.meta, context);
        if (!schema.properties.isEmpty()) {
            final PathPart parentPart = PathPart.makeLeft("properties");
            JerialContext parentContext = context.push(parentPart);
            for (Map.Entry<String, Meta> props : schema.properties.entrySet()) {
                final PathPart part = PathPart.makeLeft(props.getKey());
                JerialContext childContext = parentContext.push(part);
                metaJerializer.jerialize(registry, props.getValue(), childContext);
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
}
