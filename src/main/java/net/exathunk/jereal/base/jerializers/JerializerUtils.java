package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.DSLImpl;
import net.exathunk.jereal.base.dsl.JThingContext;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.util.JsonObjectWriter;
import net.exathunk.jereal.base.util.JsonParser;

/**
 * charolastra 10/27/12 2:49 PM
 */
public class JerializerUtils {

    public static <V> JObject domainToJObject(JerializerRegistry registry,
                                              Jerializer<JThingContext, JThing, V> jerializer, V domain) throws JerializerException {
        Recurser<JThingContext, JThing> recurser = new RecurserImpl<JThingContext, JThing>(registry);
        DSL dsl = new DSLImpl(new JThingContext());
        ObjectDSL<JThingContext, JThing> objectDSL = dsl.seeObject();
        jerializer.jerialize(recurser, objectDSL, domain);
        return objectDSL.seeObjectEnd().rawGetObject();
    }

    public static <V> JObject domainToJObject(JerializerRegistry registry,
                                              V domain) throws JerializerException {
        Jerializer<JThingContext, JThing, V> jerializer = registry.getJerializer(domain.getClass());
        return domainToJObject(registry, jerializer, domain);
    }

    // for parity
    public static <T> void jobjectToDomain(DejerializerRegistry registry, Dejerializer<T> dejerializer,
                                           JObject jobject, T domain) throws JerializerException {
        dejerializer.dejerialize(registry, jobject, domain);
    }

    public static String jobjectToJson(JObject jobject) throws VisitException {
        JsonObjectWriter visitor = new JsonObjectWriter();
        jobject.acceptTyped(Path.root(), visitor);
        StringBuilder sb = new StringBuilder();
        visitor.runFunc(sb);
        return sb.toString();
    }

    public static <V> String domainToJson(JerializerRegistry registry,
                                          Jerializer<JThingContext, JThing, V> jerializer, V domain) throws JerializerException, VisitException {
        return jobjectToJson(domainToJObject(registry, jerializer, domain));
    }

    public static <V> String domainToJson(JerializerRegistry registry,
                                          V domain) throws JerializerException, VisitException {
        Jerializer<JThingContext, JThing, V> jerializer = registry.getJerializer(domain.getClass());
        return jobjectToJson(domainToJObject(registry, jerializer, domain));
    }

    public static JObject jsonToJObject(String json) throws JerializerException {
        JsonParser parser = new JsonParser();
        return parser.parse(json).rawGetObject();
    }

    public static <T> void jsonToDomain(DejerializerRegistry registry,
                                        Dejerializer<T> dejerializer, String json, T domain) throws JerializerException {
        jobjectToDomain(registry, dejerializer, jsonToJObject(json), domain);
    }
}
