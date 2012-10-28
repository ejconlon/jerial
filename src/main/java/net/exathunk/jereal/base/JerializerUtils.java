package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.VisitorFactory;
import net.exathunk.jereal.base.visitors.Writer;

/**
 * charolastra 10/27/12 2:49 PM
 */
public class JerializerUtils {

    public static <T> Jerial domainToJerial(JerialBuilderFactory factory, JerializerRegistry registry,
                                            Jerializer<T> jerializer, T domain) throws JerializerException {
        JerialContext context = new JerialContext(factory);
        jerializer.jerialize(registry, domain, context);
        return context.builder.buildJerial();
    }

    public static <T> Jerial domainToJerial(JerialBuilderFactory factory, JerializerRegistry registry,
                                            T domain) throws JerializerException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
        return domainToJerial(factory, registry, jerializer, domain);
    }

    // for parity
    public static <T> void jerialToDomain(DejerializerRegistry registry, Dejerializer<T> dejerializer,
                                          Jerial jerial, T domain) throws JerializerException {
        dejerializer.dejerialize(registry, jerial, domain);
    }

    public static String jerialToJson(Jerial jerial) {
        VisitorFactory<StringBuilder> objectWriter = new JsonObjectWriter();
        Writer<StringBuilder> stringWriter = (new JerialRunner<StringBuilder>()).runJerialVisitor(jerial, objectWriter);
        StringBuilder sb = new StringBuilder();
        stringWriter.writeTo(sb);
        return sb.toString();
    }

    public static <T> String domainToJson(JerialBuilderFactory factory, JerializerRegistry registry,
                                          Jerializer<T> jerializer, T domain) throws JerializerException {
        return jerialToJson(domainToJerial(factory, registry, jerializer, domain));
    }

    public static <T> String domainToJson(JerialBuilderFactory factory, JerializerRegistry registry,
                                          T domain) throws JerializerException {
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)domain.getClass());
        return jerialToJson(domainToJerial(factory, registry, jerializer, domain));
    }

    public static Jerial jsonToJerial(JerialBuilderFactory factory, String json) throws JerializerException {
        VisitorFactory<JerialContext> reader = new JsonObjectReader();
        Writer<JerialContext> contextWriter = (new JsonParser<JerialContext>()).runJerialVisitor(json, reader);
        JerialContext context = new JerialContext(factory);
        contextWriter.writeTo(context);
        return context.builder.buildJerial();
    }

    public static <T> void jsonToDomain(JerialBuilderFactory factory, DejerializerRegistry registry,
                                     Dejerializer<T> dejerializer, String json, T domain) throws JerializerException {
        jerialToDomain(registry, dejerializer, jsonToJerial(factory, json), domain);
    }
}
