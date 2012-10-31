package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.schema.domain.Link;

/**
 * charolastra 10/27/12 5:50 PM
 */
public class LinkJerializer implements Jerializer<Link> {
    @Override
    public void jerialize(JerializerRegistry registry, Link link, JerialContext context) throws JerializerException {
        JDSLImpl jdsl = new JDSLImpl();
        jdsl.addString("rel", link.rel, context);
        jdsl.addString("href", link.href, context);
        jdsl.addString("schema", link.schema, context);
        jdsl.addString("targetSchema", link.targetSchema, context);
        jdsl.addString("enctype", link.enctype, context);
        jdsl.addString("method", link.method, context);
        jdsl.addMap(registry, PathPart.key("properties"), link.properties, context);
    }
}
