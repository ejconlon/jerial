package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.functional.Either;

/**
 * charolastra 10/27/12 7:06 PM
 */
public class SchemaRef extends Either<Schema, String> {
    protected SchemaRef(Schema schema, String ref) {
        super(schema, ref);
    }

    public static SchemaRef makeSchema(Schema schema) {
        return new SchemaRef(schema, null);
    }

    public static SchemaRef makeRef(String ref) {
        return new SchemaRef(null, ref);
    }
}
