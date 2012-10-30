package net.exathunk.jereal.schema.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Reference;
import net.exathunk.jereal.base.operators.*;
import net.exathunk.jereal.base.operators.core.JBooleanOperator;
import net.exathunk.jereal.base.operators.core.JLongOperator;
import net.exathunk.jereal.base.operators.core.JStringOperator;
import net.exathunk.jereal.schema.domain.Schema;

/**
 * charolastra 10/29/12 12:36 PM
 */
public class SchemaOperatorMapBuilder implements OperatorMapBuilder<Schema, ExecutionException> {

    public void declare(Declarer<Schema, ExecutionException> dec) throws DeclarationException {
        // 8 simple string
        dec.declare(Path.singletonKey("$ref"), SuperModel.STRING);
        dec.declare(Path.singletonKey("$schema"), SuperModel.STRING);
        dec.declare(Path.singletonKey("description"), SuperModel.STRING);
        dec.declare(Path.singletonKey("format"), SuperModel.STRING);
        dec.declare(Path.singletonKey("fragmentResolution"), SuperModel.STRING);
        dec.declare(Path.singletonKey("id"), SuperModel.STRING);
        dec.declare(Path.singletonKey("name"), SuperModel.STRING);
        dec.declare(Path.singletonKey("title"), SuperModel.STRING);

        // 2 simple boolean
        dec.declare(Path.singletonKey("required"), SuperModel.BOOLEAN);
        dec.declare(Path.singletonKey("uniqueItems"), SuperModel.BOOLEAN);

        // 2 simple long
        dec.declare(Path.singletonKey("minimum"), SuperModel.LONG);
        dec.declare(Path.singletonKey("minItems"), SuperModel.LONG);

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

    public void implement(Declarer<Schema, ExecutionException> dec) throws DeclarationException {
        // 8 simple string
        dec.reopen(Path.singletonKey("$ref")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.dollar_ref = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("$schema")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.dollar_schema = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("description")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.description = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("format")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.format = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("fragmentResolution")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.fragmentResolution = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("id")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.id = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("name")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.name = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("title")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.title = thing.runResFunc();
            }
        });

        // 2 simple boolean
        dec.reopen(Path.singletonKey("required")).implement(SuperModel.BOOLEAN, new JBooleanOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JBoolean thing, Schema schema, Reference<ExecutionException> fail) {
                schema.required = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("uniqueItems")).implement(SuperModel.BOOLEAN, new JBooleanOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JBoolean thing, Schema schema, Reference<ExecutionException> fail) {
                schema.uniqueItems = thing.runResFunc();
            }
        });

        // 2 simple long
        dec.reopen(Path.singletonKey("minimum")).implement(SuperModel.LONG, new JLongOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JLong thing, Schema schema, Reference<ExecutionException> fail) {
                schema.minimum = thing.runResFunc();
            }
        });
        dec.reopen(Path.singletonKey("minItems")).implement(SuperModel.LONG, new JLongOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JLong thing, Schema schema, Reference<ExecutionException> fail) {
                schema.minItems = thing.runResFunc();
            }
        });
    }

    public void buildOperatorMap(OperatorMap<Schema, ExecutionException> opMap) throws DeclarationException {
        final Declarer<Schema, ExecutionException> dec = new Declarer<Schema, ExecutionException>();
        declare(dec);
        implement(dec);
        dec.buildOperatorMap(opMap);
    }
}
