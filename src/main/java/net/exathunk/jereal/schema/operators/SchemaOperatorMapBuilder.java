package net.exathunk.jereal.schema.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Reference;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.operators.*;
import net.exathunk.jereal.base.operators.core.JArrayOperator;
import net.exathunk.jereal.base.operators.core.JBooleanOperator;
import net.exathunk.jereal.base.operators.core.JLongOperator;
import net.exathunk.jereal.base.operators.core.JStringOperator;
import net.exathunk.jereal.base.operators.declaration.*;
import net.exathunk.jereal.schema.domain.Link;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.util.SchemaRegistryFactorySingleton;

import java.util.Map;

/**
 * charolastra 10/29/12 12:36 PM
 */
public class SchemaOperatorMapBuilder implements OperatorMapBuilder<Schema, ExecutionException> {

    public void declare(DeclarationBuilder<Schema, ExecutionException> dec) throws DeclarationException {
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

        // 1 simple array
        dec.declare(Path.singletonKey("links"), SuperModel.ARRAY);

        /*// 1 simple object
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

    public void implement(ImplementerPathMap<Schema, ExecutionException> imp) throws DeclarationException {
        // 8 simple string
        imp.path(Path.singletonKey("$ref")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.dollar_ref = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("$schema")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.dollar_schema = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("description")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.description = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("format")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.format = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("fragmentResolution")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.fragmentResolution = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("id")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.id = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("name")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.name = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("title")).implement(SuperModel.STRING, new JStringOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JString thing, Schema schema, Reference<ExecutionException> fail) {
                schema.title = thing.runResFunc();
            }
        });

        // 2 simple boolean
        imp.path(Path.singletonKey("required")).implement(SuperModel.BOOLEAN, new JBooleanOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JBoolean thing, Schema schema, Reference<ExecutionException> fail) {
                schema.required = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("uniqueItems")).implement(SuperModel.BOOLEAN, new JBooleanOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JBoolean thing, Schema schema, Reference<ExecutionException> fail) {
                schema.uniqueItems = thing.runResFunc();
            }
        });

        // 2 simple long
        imp.path(Path.singletonKey("minimum")).implement(SuperModel.LONG, new JLongOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JLong thing, Schema schema, Reference<ExecutionException> fail) {
                schema.minimum = thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("minItems")).implement(SuperModel.LONG, new JLongOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JLong thing, Schema schema, Reference<ExecutionException> fail) {
                schema.minItems = thing.runResFunc();
            }
        });

        // 1 simple array
        imp.path(Path.singletonKey("links")).implement(SuperModel.ARRAY, new JArrayOperator<Schema, ExecutionException>() {
            @Override
            public void runFunc(Path path, JArray thing, Schema schema, Reference<ExecutionException> fail) {
                RegistryFactory factory = SchemaRegistryFactorySingleton.getInstance();
                DejerializerRegistry registry = factory.makeDejerializerRegistry();
                try {
                    Dejerializer<Link> linkDejerializer = registry.getDejerializer(Link.class);
                    for (Map.Entry<Integer, JThing> entry : thing.seq()) {
                        Link link = new Link();
                        linkDejerializer.dejerialize(registry, entry.getValue().rawGetObject(), link);
                        schema.links.add(link);
                    }
                } catch (JerializerException e) {
                    fail.setReference(new ExecutionException("link jerializer bs", e));
                }
            }
        });
    }

    public void buildOperatorMap(OperatorMap<Schema, ExecutionException> opMap) throws DeclarationException {
        final DeclarationBuilder<Schema, ExecutionException> dec = new DeclarationBuilder<Schema, ExecutionException>();
        declare(dec);
        final ImplementerPathMap<Schema, ExecutionException> imp = dec.buildImplementers().dir(Implementer.Direction.SERIALIZE);
        implement(imp);
        imp.buildOperatorMap(opMap);
    }
}
