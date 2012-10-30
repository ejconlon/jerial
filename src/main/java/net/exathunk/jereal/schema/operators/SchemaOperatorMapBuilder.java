package net.exathunk.jereal.schema.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.operators.*;
import net.exathunk.jereal.base.operators.core.*;
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
        dec.declare(Path.singletonKey("$ref"), Model.STRING);
        dec.declare(Path.singletonKey("$schema"), Model.STRING);
        dec.declare(Path.singletonKey("description"), Model.STRING);
        dec.declare(Path.singletonKey("format"), Model.STRING);
        dec.declare(Path.singletonKey("fragmentResolution"), Model.STRING);
        dec.declare(Path.singletonKey("id"), Model.STRING);
        dec.declare(Path.singletonKey("name"), Model.STRING);
        dec.declare(Path.singletonKey("title"), Model.STRING);

        // 2 simple boolean
        dec.declare(Path.singletonKey("required"), Model.BOOLEAN);
        dec.declare(Path.singletonKey("uniqueItems"), Model.BOOLEAN);

        // 2 simple long
        dec.declare(Path.singletonKey("minimum"), Model.LONG);
        dec.declare(Path.singletonKey("minItems"), Model.LONG);

        // 1 simple array
        dec.declare(Path.singletonKey("links"), Model.ARRAY);

        /*// 1 simple object
        dec.declare("dependencies", Model.OBJECT);
        dec.declare("properties", Model.OBJECT);

        // 1 simple any
        dec.declare("default", Model.ANY);

        // 4 union
        dec.declare("extends", Model.STRING, Model.OBJECT);
        dec.declare("type", Model.STRING, Model.ARRAY, Model.OBJECT);
        dec.declare("items", Model.STRING, Model.ARRAY, Model.OBJECT);
        dec.declare("additionalProperties", Model.STRING, Model.BOOLEAN, Model.OBJECT);
        */
    }

    public void implement(ImplementerMap<JThing, Schema> imp) throws DeclarationException {
        // 8 simple string
        imp.path(Path.singletonKey("$ref")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.dollar_ref = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("$schema")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.dollar_schema = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("description")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.description = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("format")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.format = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("fragmentResolution")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.fragmentResolution = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("id")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.id = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("name")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.name = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("title")).implement(Model.STRING, new JStringOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JString> argC) {
                opC.domain.title = argC.thing.runResFunc();
            }
        });

        // 2 simple boolean
        imp.path(Path.singletonKey("required")).implement(Model.BOOLEAN, new JBooleanOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JBoolean> argC) {
                opC.domain.required = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("uniqueItems")).implement(Model.BOOLEAN, new JBooleanOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JBoolean> argC) {
                opC.domain.uniqueItems = argC.thing.runResFunc();
            }
        });

        // 2 simple long
        imp.path(Path.singletonKey("minimum")).implement(Model.LONG, new JLongOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JLong> argC) {
                opC.domain.minimum = argC.thing.runResFunc();
            }
        });
        imp.path(Path.singletonKey("minItems")).implement(Model.LONG, new JLongOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JLong> argC) {
                opC.domain.minItems = argC.thing.runResFunc();
            }
        });

        // 1 simple array
        imp.path(Path.singletonKey("links")).implement(Model.ARRAY, new JArrayOperator<Schema>() {
            @Override
            public void typedRunFunc(OpContext<JThing, Schema> opC, ArgContext<JArray> argC) {
                RegistryFactory factory = SchemaRegistryFactorySingleton.getInstance();
                DejerializerRegistry registry = factory.makeDejerializerRegistry();
                try {
                    Dejerializer<Link> linkDejerializer = registry.getDejerializer(Link.class);
                    for (Map.Entry<Integer, JThing> entry : argC.thing.seq()) {
                        Link link = new Link();
                        linkDejerializer.dejerialize(registry, entry.getValue().rawGetObject(), link);
                        opC.domain.links.add(link);
                    }
                } catch (JerializerException e) {
                    opC.fail(new OperatorException("link jer stuff", e));
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
