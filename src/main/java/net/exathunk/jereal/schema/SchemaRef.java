package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.functional.Either;

/**
 * charolastra 10/27/12 7:55 PM
 */
public class SchemaRef<T> extends Either<Schema, T> {
    protected SchemaRef(Schema schema, T ref) {
        super(schema, ref);
    }

    public static <T> SchemaRef<T> makeSchema(Schema schema) {
        return new SchemaRef(schema, null);
    }

    public static <T> SchemaRef<T> makeRef(T ref) {
        return new SchemaRef(null, ref);
    }
}
