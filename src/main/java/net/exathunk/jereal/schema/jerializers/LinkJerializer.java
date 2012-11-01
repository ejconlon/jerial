package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.schema.domain.Link;

/**
 * charolastra 10/27/12 5:50 PM
 */
public class LinkJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Link> {
    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Link link) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("rel", link.rel);
        objectDSL.seeString("href", link.href);
        objectDSL.seeString("schema", link.schema);
        objectDSL.seeString("targetSchema", link.targetSchema);
        objectDSL.seeString("enctype", link.enctype);
        objectDSL.seeString("method", link.method);
        objectDSL.seeWritable("properties", recurser.seeCustomMap(dsl, link.properties));
        return objectDSL;
    }
}
