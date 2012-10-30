package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.builders.JerialBuilderFactory;
import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.functional.Maybe;
import net.exathunk.jereal.base.visitors.VisitException;
import net.exathunk.jereal.base.visitors.VisitorFactory;
/**
 * charolastra 10/27/12 2:49 PM
 */
public class JerializerUtils {

    public static <T> JObject domainToJObject(JerialBuilderFactory factory, JerializerRegistry registry,
                                              Jerializer<T> jerializer, T domain) throws JerializerException {
        JerialContext context = new JerialContext(factory);
        jerializer.jerialize(registry, domain, context);
        return context.builder.buildObject();
    }

    public static <T> JObject domainToJObject(JerialBuilderFactory factory, JerializerRegistry registry,
                                              T domain) throws JerializerException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
        return domainToJObject(factory, registry, jerializer, domain);
    }

    // for parity
    public static <T> void jobjectToDomain(DejerializerRegistry registry, Dejerializer<T> dejerializer,
                                           JObject jobject, T domain) throws JerializerException {
        dejerializer.dejerialize(registry, jobject, domain);
    }

    public static String jobjectToJson(JObject jobject) throws VisitException {
        JsonObjectWriter visitor = new JsonObjectWriter();
        jobject.accept(ConsList.<PathPart>nil(), visitor);
        StringBuilder sb = new StringBuilder();
        visitor.runFunc(sb);
        return sb.toString();
    }

    public static <T> String domainToJson(JerialBuilderFactory factory, JerializerRegistry registry,
                                          Jerializer<T> jerializer, T domain) throws JerializerException, VisitException {
        return jobjectToJson(domainToJObject(factory, registry, jerializer, domain));
    }

    public static <T> String domainToJson(JerialBuilderFactory factory, JerializerRegistry registry,
                                          T domain) throws JerializerException, VisitException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
        return jobjectToJson(domainToJObject(factory, registry, jerializer, domain));
    }

    public static JObject jsonToJObject(String json) throws JerializerException {
        NewJsonParser parser = new NewJsonParser();
        return parser.parse(json).rawGetObject();
    }

    public static <T> void jsonToDomain(JerialBuilderFactory factory, DejerializerRegistry registry,
                                        Dejerializer<T> dejerializer, String json, T domain) throws JerializerException {
        jobjectToDomain(registry, dejerializer, jsonToJObject(json), domain);
    }
}
