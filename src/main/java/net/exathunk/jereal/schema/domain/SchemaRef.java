package net.exathunk.jereal.schema.domain;

import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 10/27/12 7:55 PM
 */
public class SchemaRef<T> extends Either<Ref<Schema>, Ref<T>> {
    protected SchemaRef(Ref<Schema> schema, Ref<T> ref) {
        super(schema, ref);
    }

    public static <T> SchemaRef<T> makeSchema(Schema schema) {
        return new SchemaRef<T>(new RefImpl<Schema>(schema), null);
    }

    public static <T> SchemaRef<T> makeRef(T ref) {
        return new SchemaRef<T>(null, new RefImpl<T>(ref));
    }
}
