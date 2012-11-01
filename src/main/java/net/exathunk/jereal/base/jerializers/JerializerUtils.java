package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.util.JsonObjectWriter;
import net.exathunk.jereal.base.util.JsonParser;

import java.util.Map;

/**
 * charolastra 10/27/12 2:49 PM
 */
public class JerializerUtils {

    public static <V> JThing domainToJThing(JerializerRegistry registry,
                                             Jerializer<JThingContext, JThing, V> jerializer, V domain) throws JerializerException {
        Recurser<JThingContext, JThing> recurser = new RecurserImpl<JThingContext, JThing>(registry);
        DSL dsl = new DSLImpl(new ResFunc0<JThingContext>() {
            @Override
            public JThingContext runResFunc() {
                return new JThingContext();
            }
        });
        Pipeable<JThing> pipeable = jerializer.jerialize(recurser, dsl, domain);
        Cont<JThing> cont = new ContSingle<JThing>();
        pipeable.pipe(cont);
        return cont.getSingle().getRef();
    }

    public static <V> JThing domainToJThing(JerializerRegistry registry,
                                            V domain) throws JerializerException {
        Jerializer<JThingContext, JThing, V> jerializer = registry.getJerializer(domain.getClass());
        return domainToJThing(registry, jerializer, domain);
    }

    // for parity
    public static <V> void jthingToDomain(JerializerRegistry registry, Jerializer<DomainContext, JThing, V> jerializer,
                                          JThing thing, V domain) throws JerializerException {
        Recurser<DomainContext, JThing> recurser = new RecurserImpl<DomainContext, JThing>(registry);
        DSL dsl = new DSLImpl(new ResFunc0<DomainContext>() {
            @Override
            public DomainContext runResFunc() {
                return new DomainContext();
            }
        });
        Pipeable<JThing> pipeable = jerializer.jerialize(recurser, dsl, domain);
        Cont<JThing> cont = new ContMap<JThing>(new RefImpl<Map<String, JThing>>(thing.rawGetObject().getMap()));
        pipeable.pipe(cont);
    }

    public static String jthingToJson(JThing thing) throws VisitException {
        JsonObjectWriter visitor = new JsonObjectWriter();
        thing.acceptTyped(Path.root(), visitor);
        StringBuilder sb = new StringBuilder();
        visitor.runFunc(sb);
        return sb.toString();
    }

    public static <V> String domainToJson(JerializerRegistry registry,
                                          Jerializer<JThingContext, JThing, V> jerializer, V domain) throws JerializerException, VisitException {
        return jthingToJson(domainToJThing(registry, jerializer, domain));
    }

    public static <V> String domainToJson(JerializerRegistry registry,
                                          V domain) throws JerializerException, VisitException {
        Jerializer<JThingContext, JThing, V> jerializer = registry.getJerializer(domain.getClass());
        return jthingToJson(domainToJThing(registry, jerializer, domain));
    }

    public static JThing jsonToJThing(String json) throws JerializerException {
        JsonParser parser = new JsonParser();
        return parser.parse(json);
    }

    public static <V> void jsonToDomain(JerializerRegistry registry,
                                        Jerializer<DomainContext, JThing, V> Jerializer, String json, V domain) throws JerializerException {
        jthingToDomain(registry, Jerializer, jsonToJThing(json), domain);
    }
}
