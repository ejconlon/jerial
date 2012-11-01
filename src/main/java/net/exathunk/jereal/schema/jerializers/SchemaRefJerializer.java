package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.Recurser;
import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 10/31/12 3:20 AM
 */
public class SchemaRefJerializer<T extends PushableContext<T, JThing>> implements Jerializer<T, JThing, SchemaRef> {
    @Override
    public void jerialize(Recurser<T, JThing> recurser, ObjectDSL<T, JThing> dsl, SchemaRef schemaRef) throws JerializerException {
        if (schemaRef.hasLeft()) {
            (new SchemaJerializer()).jerialize(recurser, dsl, schemaRef.getLeft());
        } else if (schemaRef.hasRight()) {
            dsl.seeRaw(JThing.make(schemaRef.getRight()));
        }
    }
}
