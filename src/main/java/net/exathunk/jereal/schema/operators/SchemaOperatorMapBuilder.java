package net.exathunk.jereal.schema.operators;

import net.exathunk.jereal.base.core.*;
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
public class SchemaOperatorMapBuilder implements OperatorMapBuilder<JThing, Schema> {

    public void declare(DeclarationBuilder dec) throws DeclarationException {
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

    public void implement(ImplementerMap<JThing, Schema> imp) throws DeclarationException {
        // 8 simple string
        imp.path(Path.singletonKey("$ref")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().dollar_ref = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("$schema")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().dollar_schema = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("description")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().description = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("format")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().format = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("fragmentResolution")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().fragmentResolution = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("id")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().id = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("name")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().name = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("title")).implement(SuperModel.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JString, Schema> c) {
                c.out.getLeft().title = c.thing.runResFunc();
            }
        });

        // 2 simple boolean
        imp.path(Path.singletonKey("required")).implement(SuperModel.BOOLEAN, new JBooleanOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JBoolean, Schema> c) {
                c.out.getLeft().required = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("uniqueItems")).implement(SuperModel.BOOLEAN, new JBooleanOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JBoolean, Schema> c) {
                c.out.getLeft().uniqueItems = c.thing.runResFunc();
            }
        });

        // 2 simple long
        imp.path(Path.singletonKey("minimum")).implement(SuperModel.LONG, new JLongOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JLong, Schema> c) {
                c.out.getLeft().minimum = c.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("minItems")).implement(SuperModel.LONG, new JLongOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JLong, Schema> c) {
                c.out.getLeft().minItems = c.thing.runResFunc();
            }
        });

        // 1 simple array
        imp.path(Path.singletonKey("links")).implement(SuperModel.ARRAY, new JArrayOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JArray, Schema> c) {
                RegistryFactory factory = SchemaRegistryFactorySingleton.getInstance();
                DejerializerRegistry registry = factory.makeDejerializerRegistry();
                try {
                    Dejerializer<Link> linkDejerializer = registry.getDejerializer(Link.class);
                    for (Map.Entry<Integer, JThing> entry : c.thing.seq()) {
                        Link link = new Link();
                        linkDejerializer.dejerialize(registry, entry.getValue().rawGetObject(), link);
                        c.out.getLeft().links.add(link);
                    }
                } catch (JerializerException e) {
                    c.fail(new OperatorException("link jer stuff", e));
                }
            }
        });
    }

    public void buildOperatorMap(OperatorMap<JThing, Schema> opMap) throws DeclarationException {
        final DeclarationBuilder dec = new DeclarationBuilder();
        declare(dec);
        final ImplementerMap<JThing, Schema> imp = dec.buildImplementerMap();
        implement(imp);
        imp.buildOperatorMap(opMap);
    }
}
