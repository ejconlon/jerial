package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.builders.JerialBuilderFactory;
import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.functional.Maybe;
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

    public static String jobjectToJson(JObject jobject) throws JerializerException {
        VisitorFactory<StringBuilder> objectWriter = new JsonObjectWriter();
        Maybe<Func1<StringBuilder>> maybeWriter = JThing.make(jobject).accept(objectWriter);
        if (maybeWriter.isNothing()) throw new JerializerException("No writer");
        StringBuilder sb = new StringBuilder();
        maybeWriter.unJust().runFunc(sb);
        return sb.toString();
    }

    public static <T> String domainToJson(JerialBuilderFactory factory, JerializerRegistry registry,
                                          Jerializer<T> jerializer, T domain) throws JerializerException {
        return jobjectToJson(domainToJObject(factory, registry, jerializer, domain));
    }

    public static <T> String domainToJson(JerialBuilderFactory factory, JerializerRegistry registry,
                                          T domain) throws JerializerException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
        return jobjectToJson(domainToJObject(factory, registry, jerializer, domain));
    }

    public static JObject jsonToJObject(JerialBuilderFactory factory, String json) throws JerializerException {
        VisitorFactory<JerialContext> reader = new JsonObjectReader();
        Func1<JerialContext> contextWriter = (new JsonParser<JerialContext>()).runVisitor(json, reader);
        JerialContext context = new JerialContext(factory);
        contextWriter.runFunc(context);
        return context.builder.buildObject();
    }

    public static <T> void jsonToDomain(JerialBuilderFactory factory, DejerializerRegistry registry,
                                        Dejerializer<T> dejerializer, String json, T domain) throws JerializerException {
        jobjectToDomain(registry, dejerializer, jsonToJObject(factory, json), domain);
    }
}
