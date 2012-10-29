package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/27/12 5:50 PM
 */
public class LinkJerializer implements Jerializer<Link> {
    @Override
    public void jerialize(JerializerRegistry registry, Link link, JerialContext context) throws JerializerException {
        JDSL.addString("rel", link.rel, context);
        JDSL.addString("href", link.href, context);
        JDSL.addString("schema", link.schema, context);
        JDSL.addString("targetSchema", link.targetSchema, context);
        JDSL.addString("enctype", link.enctype, context);
        JDSL.addString("method", link.method, context);
        if (!link.properties.isEmpty()) JDSL.addMap(registry, PathPart.key("properties"), link.properties, context);
    }
}
