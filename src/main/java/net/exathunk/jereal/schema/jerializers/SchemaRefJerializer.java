package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.Recurser;
import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 10/31/12 3:20 AM
 */
public class SchemaRefJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, SchemaRef> {
    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, SchemaRef schemaRef) throws JerializerException {
        if (schemaRef.hasLeft()) {
            return (new SchemaJerializer<T, U>()).jerialize(recurser, dsl, schemaRef.getLeft());
        } else {
            return dsl.seeString(new RefImpl<String>(schemaRef.getRight()));
        }
    }
}
