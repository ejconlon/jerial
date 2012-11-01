package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.DSLImpl;
import net.exathunk.jereal.base.dsl.JThingContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.functional.ResFunc0;
import net.exathunk.jereal.base.util.JsonObjectWriter;
import net.exathunk.jereal.base.util.JsonParser;

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
        Writable<JThing> writable = jerializer.jerialize(recurser, dsl, domain);
        Ref<JThing> ref = new RefImpl<JThing>();
        writable.writeTo(ref);
        return ref.getRef();
    }

    public static <V> JThing domainToJThing(JerializerRegistry registry,
                                            V domain) throws JerializerException {
        Jerializer<JThingContext, JThing, V> jerializer = registry.getJerializer(domain.getClass());
        return domainToJThing(registry, jerializer, domain);
    }

    // for parity
    public static <T> void jthingToDomain(DejerializerRegistry registry, Dejerializer<T> dejerializer,
                                          JThing thing, T domain) throws JerializerException {
        // TODO dejerialize
        dejerializer.dejerialize(registry, thing.rawGetObject(), domain);
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

    public static <T> void jsonToDomain(DejerializerRegistry registry,
                                        Dejerializer<T> dejerializer, String json, T domain) throws JerializerException {
        jthingToDomain(registry, dejerializer, jsonToJThing(json), domain);
    }
}
