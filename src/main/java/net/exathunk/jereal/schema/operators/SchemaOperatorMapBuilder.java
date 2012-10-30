package net.exathunk.jereal.schema.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.ResFunc0;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.operators.*;
import net.exathunk.jereal.base.operators.converters.Converter;
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
        //dec.declare(Path.singletonKey("$ref"), Model.STRING);
        //dec.declare(Path.singletonKey("$schema"), Model.STRING);
        //dec.declare(Path.singletonKey("description"), Model.STRING);
        //dec.declare(Path.singletonKey("format"), Model.STRING);
        //dec.declare(Path.singletonKey("fragmentResolution"), Model.STRING);
        dec.declare(Path.singletonKey("id"), Model.STRING);
        //dec.declare(Path.singletonKey("name"), Model.STRING);
        //dec.declare(Path.singletonKey("title"), Model.STRING);

        // 2 simple boolean
        dec.declare(Path.singletonKey("required"), Model.BOOLEAN);
        //dec.declare(Path.singletonKey("uniqueItems"), Model.BOOLEAN);

        // 2 simple long
        //dec.declare(Path.singletonKey("minimum"), Model.LONG);
        //dec.declare(Path.singletonKey("minItems"), Model.LONG);

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

        imp.path(Path.singletonKey("id")).implement(Model.STRING, new JStringOperator<Schema, Schema>(new Operator<JThing, JString, Schema, Schema>() {
            @Override
            public void runFunc(OpContext<JThing, Schema> opC, ArgContext argC, JString thing, Schema domain) {
                domain.id = thing.runResFunc();
            }
        }));

        // 2 simple boolean
        imp.path(Path.singletonKey("required")).implement(Model.BOOLEAN, new JBooleanOperator<Schema, Schema>(new Operator<JThing, JBoolean, Schema, Schema>() {
            @Override
            public void runFunc(OpContext<JThing, Schema> opC, ArgContext argC, JBoolean thing, Schema domain) {
                domain.required = thing.runResFunc();
            }
        }));


        // 1 simple array
        imp.path(Path.singletonKey("links")).implement(Model.ARRAY, new JArrayOperator<Schema, Schema>(new JArrayMapOperator<Schema, Schema, Link>(new Converter<Schema, ResFunc0<Link>>() {
            @Override
            public ResFunc0<Link> convert(final Schema schema) throws OperatorException {
                return new ResFunc0<Link>() {
                    @Override
                    public Link runResFunc() {
                        Link link = new Link();
                        schema.links.add(link);
                        return link;
                    }
                };
            }
        }, new JObjectOperator<Schema, Link>(new Operator<JThing, JObject, Schema, Link>() {
            @Override
            public void runFunc(OpContext<JThing, Schema> opC, ArgContext argC, JObject thing, Link link) {
                RegistryFactory factory = SchemaRegistryFactorySingleton.getInstance();
                DejerializerRegistry registry = factory.makeDejerializerRegistry();
                try {
                    Dejerializer<Link> linkDejerializer = registry.getDejerializer(Link.class);
                    linkDejerializer.dejerialize(registry, thing, link);
                } catch (JerializerException e) {
                    opC.fail(new OperatorException("link jer stuff", e));
                }
            }
        }))));
    }

    public void buildOperatorMap(OperatorMap<JThing, Schema> opMap) throws DeclarationException {
        final DeclarationBuilder dec = new DeclarationBuilder();
        declare(dec);
        final ImplementerMap<JThing, Schema> imp = dec.buildImplementerMap();
        implement(imp);
        imp.buildOperatorMap(opMap);
    }
}
