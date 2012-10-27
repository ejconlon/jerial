package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.Dejerializer;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.DejerializerRegistry;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/27/12 2:00 PM
 */
public class SchemaDejerializer implements Dejerializer<Schema> {
    @Override
    public Schema dejerialize(DejerializerRegistry registry, Jerial jerial) throws JerializerException {
        Schema s = new Schema();
        for (Jitem item : jerial) {
            final PathPart part = item.getPart();
            if (part.hasRight()) throw new JerializerException("Unexpected array elt");
            else {
                final String key = part.getLeft();
                if (part.equals("name")) {
                    s.meta.name = key;
                } else {
                    throw new JerializerException("UNHANDLED: "+key);
                }
            }
        }
        return s;
    }
}
