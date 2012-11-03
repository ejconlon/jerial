package net.exathunk.jereal.schema.domain;

import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 10/27/12 7:55 PM
 */
public class SchemaRef extends Either<Ref<Schema>, Ref<String>> {
    protected SchemaRef(Ref<Schema> schema, Ref<String> ref) {
        super(schema, ref);
    }

    public static SchemaRef makeSchema(Schema schema) {
        return new SchemaRef(new RefImpl<Schema>(schema), null);
    }

    public static SchemaRef makeRef(String ref) {
        return new SchemaRef(null, new RefImpl<String>(ref));
    }
}
