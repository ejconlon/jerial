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
    public void jerialize(JDSL jdsl, Link link) throws JerializerException {
        jdsl.addString("rel", link.rel);
        jdsl.addString("href", link.href);
        jdsl.addString("schema", link.schema);
        jdsl.addString("targetSchema", link.targetSchema);
        jdsl.addString("enctype", link.enctype);
        jdsl.addString("method", link.method);
        jdsl.addMap(PathPart.key("properties"), link.properties);
    }
}
