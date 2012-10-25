package net.exathunk.jereal;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.JerialVisitor;
import net.exathunk.jereal.base.visitors.Writer;

/**
 * charolastra 10/24/12 8:02 PM
 */
public class TestUtils {
    public static <T> String jerializeToString(JerialBuilderFactory f, T x, Jerializer<T> y) {
        JerialContext context = new JerialContext(f);
        y.jerialize(x, context);
        Jerial jerial = context.builder.buildJerial();
        JerialVisitor<StringBuilder> objectWriter = new JsonObjectWriter();
        Writer<StringBuilder> stringWriter = (new JerialRunner<StringBuilder>()).runJerialVisitor(jerial, objectWriter);
        StringBuilder sb = new StringBuilder();
        stringWriter.writeTo(sb);
        return sb.toString();
    }

    public static Jerial jerializeFromString(JerialBuilderFactory f, String x) throws JerializerException {
        JerialVisitor<JerialContext> reader = new JsonObjectReader();
        Writer<JerialContext> contextWriter = (new JsonParser<JerialContext>()).runJerialVisitor(x, reader);
        JerialContext context = new JerialContext(f);
        contextWriter.writeTo(context);
        return context.builder.buildJerial();
    }
}
