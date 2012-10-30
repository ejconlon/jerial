package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.util.JsonObjectWriter;
import net.exathunk.jereal.base.util.JsonParser;

/**
 * charolastra 10/27/12 2:49 PM
 */
public class JerializerUtils {

    public static <T> JObject domainToJObject(JerializerRegistry registry,
                                              Jerializer<T> jerializer, T domain) throws JerializerException {
        JerialContext context = new JerialContext();
        jerializer.jerialize(registry, domain, context);
        return context.builder.buildObject();
    }

    public static <T> JObject domainToJObject(JerializerRegistry registry,
                                              T domain) throws JerializerException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
        return domainToJObject(registry, jerializer, domain);
    }

    // for parity
    public static <T> void jobjectToDomain(DejerializerRegistry registry, Dejerializer<T> dejerializer,
                                           JObject jobject, T domain) throws JerializerException {
        dejerializer.dejerialize(registry, jobject, domain);
    }

    public static String jobjectToJson(JObject jobject) throws VisitException {
        JsonObjectWriter visitor = new JsonObjectWriter();
        jobject.accept(Path.root(), visitor);
        StringBuilder sb = new StringBuilder();
        visitor.runFunc(sb);
        return sb.toString();
    }

    public static <T> String domainToJson(JerializerRegistry registry,
                                          Jerializer<T> jerializer, T domain) throws JerializerException, VisitException {
        return jobjectToJson(domainToJObject(registry, jerializer, domain));
    }

    public static <T> String domainToJson(JerializerRegistry registry,
                                          T domain) throws JerializerException, VisitException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
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
