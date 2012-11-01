package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.schema.domain.Link;

/**
 * charolastra 10/27/12 5:50 PM
 */
public class LinkJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Link> {
    @Override
    public void jerialize(Recurser<T, U> recurser, ObjectDSL<T, U> dsl, Link link) throws JerializerException {
        dsl.seeString("rel", link.rel);
        dsl.seeString("href", link.href);
        dsl.seeString("schema", link.schema);
        dsl.seeString("targetSchema", link.targetSchema);
        dsl.seeString("enctype", link.enctype);
        dsl.seeString("method", link.method);
        recurser.seeCustomMap(dsl, "properties", link.properties);
    }
}
