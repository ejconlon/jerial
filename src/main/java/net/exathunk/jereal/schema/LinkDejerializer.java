package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.jerializers.Dejerializer;
import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/27/12 5:51 PM
 */
public class LinkDejerializer implements Dejerializer<Link> {
    @Override
    public void dejerialize(DejerializerRegistry registry, Jerial jerial, Link link) throws JerializerException {
        Dejerializer<Schema> schemaDejerializer = registry.getDejerializer(Schema.class);
        for (Jitem item : jerial) {
            final PathPart part = item.getPart();
            if (part.hasRight()) throw new JerializerException("Unexpected array elt: "+part);
            else {
                final String key = part.getLeft();
                if ("rel".equals(key)) {
                    link.rel = item.getString();
                } else if ("href".equals(key)) {
                    link.href = item.getString();
                } else if ("schema".equals(key)) {
                    link.schema = item.getString();
                } else if ("targetSchema".equals(key)) {
                    link.targetSchema = item.getString();
                } else if ("enctype".equals(key)) {
                    link.enctype = item.getString();
                } else if ("method".equals(key)) {
                    link.method = item.getString();
                } else if ("properties".equals(key)) {
                    throw new JerializerException("TODO");
                } else {
                    throw new JerializerException("Unexpected part: "+part);
                }
            }
        }
    }
}
