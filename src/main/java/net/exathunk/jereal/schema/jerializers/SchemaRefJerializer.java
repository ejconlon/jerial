package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 10/31/12 3:20 AM
 */
public class SchemaRefJerializer implements Jerializer<SchemaRef> {
    @Override
    public void jerialize(JDSL jdsl, SchemaRef schemaRef) throws JerializerException {
        if (schemaRef.hasLeft()) {
            (new SchemaJerializer()).jerialize(jdsl, schemaRef.getLeft());
        } else if (schemaRef.hasRight()) {
            jdsl.add(PathPart.key("$ref"), new RefImpl<String>(schemaRef.getRight()));
        }
    }
}
