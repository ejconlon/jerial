package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.Dejerializer;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.DejerializerRegistry;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.JerialUtils;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/27/12 2:00 PM
 */
public class SchemaDejerializer implements Dejerializer<Schema> {
    @Override
    public void dejerialize(DejerializerRegistry registry, Jerial jerial, Schema schema) throws JerializerException {
        Dejerializer<Meta> metaDejerializer = registry.getDejerializer(Meta.class);
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
                        Meta propMeta = new Meta();
                        metaDejerializer.dejerialize(registry, prop.getObject(), propMeta);
                        schema.properties.put(prop.getPart().getLeft(), propMeta);
                    }
                } else if ("links".equals(key)) {
                    throw new JerializerException("TODO");
                } else {
                    metaDejerializer.dejerialize(registry, JerialUtils.singleton(item), schema.meta);
                }
            }
        }
    }
}
