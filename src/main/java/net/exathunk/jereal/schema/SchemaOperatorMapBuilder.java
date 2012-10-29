package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.jerializers.*;

/**
 * charolastra 10/29/12 12:36 PM
 */
public class SchemaOperatorMapBuilder implements OperatorMapBuilder<Schema> {

    public void declare(Declarer<Schema> dec) throws DeclarationException {
        // 8 simple string
        dec.declare("$ref", SuperModel.STRING);
        dec.declare("$schema", SuperModel.STRING);
        dec.declare("description", SuperModel.STRING);
        dec.declare("format", SuperModel.STRING);
        dec.declare("fragmentResolution", SuperModel.STRING);
        dec.declare("id", SuperModel.STRING);
        dec.declare("name", SuperModel.STRING);
        dec.declare("title", SuperModel.STRING);

        // 2 simple boolean
        dec.declare("required", SuperModel.BOOLEAN);
        dec.declare("uniqueItems", SuperModel.BOOLEAN);

        // 2 simple long
        dec.declare("minimum", SuperModel.LONG);
        dec.declare("minItems", SuperModel.LONG);

        /*
        // 1 simple array
        dec.declare("links", SuperModel.ARRAY);

        // 1 simple object
        dec.declare("dependencies", SuperModel.OBJECT);
        dec.declare("properties", SuperModel.OBJECT);

        // 1 simple any
        dec.declare("default", SuperModel.ANY);

        // 4 union
        dec.declare("extends", SuperModel.STRING, SuperModel.OBJECT);
        dec.declare("type", SuperModel.STRING, SuperModel.ARRAY, SuperModel.OBJECT);
        dec.declare("items", SuperModel.STRING, SuperModel.ARRAY, SuperModel.OBJECT);
        dec.declare("additionalProperties", SuperModel.STRING, SuperModel.BOOLEAN, SuperModel.OBJECT);
        */
    }

    public void implement(Declarer<Schema> dec) throws DeclarationException {
        // 8 simple string
        dec.reopen("$ref").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.dollar_ref = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("$schema").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.dollar_schema = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("description").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.description = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("format").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.format = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("fragmentResolution").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.fragmentResolution = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("id").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.id = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("name").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.name = thing.rawGetString().runResFunc();
            }
        });
        dec.reopen("title").implement(SuperModel.STRING, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.title = thing.rawGetString().runResFunc();
            }
        });

        // 2 simple boolean
        dec.reopen("required").implement(SuperModel.BOOLEAN, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.required = thing.rawGetBoolean().runResFunc();
            }
        });
        dec.reopen("uniqueItems").implement(SuperModel.BOOLEAN, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.uniqueItems = thing.rawGetBoolean().runResFunc();
            }
        });

        // 2 simple long
        dec.reopen("minimum").implement(SuperModel.LONG, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.minimum = thing.rawGetLong().runResFunc();
            }
        });
        dec.reopen("minItems").implement(SuperModel.LONG, new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.minItems = thing.rawGetLong().runResFunc();
            }
        });
    }

    public void buildOperatorMap(OperatorMap<Schema> opMap) throws DeclarationException {
        final Declarer<Schema> dec = new Declarer<Schema>();
        declare(dec);
        implement(dec);
        dec.buildOperatorMap(opMap);
    }
}
