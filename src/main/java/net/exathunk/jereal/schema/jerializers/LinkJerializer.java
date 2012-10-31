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
        jdsl.addString(PathPart.key("rel"), link.rel);
        jdsl.addString(PathPart.key("href"), link.href);
        jdsl.addString(PathPart.key("schema"), link.schema);
        jdsl.addString(PathPart.key("targetSchema"), link.targetSchema);
        jdsl.addString(PathPart.key("enctype"), link.enctype);
        jdsl.addString(PathPart.key("method"), link.method);
        jdsl.addMap(PathPart.key("properties"), link.properties);
    }
}
