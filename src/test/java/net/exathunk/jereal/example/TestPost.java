package net.exathunk.jereal.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import net.exathunk.jereal.base.*;

public class TestPost {

    private final Post post = new Post("foo", "bar");

    @Test
    public void testSerializePost() throws JerializerException {
        JerialBuilderFactory factory = new SimpleMapBuilderFactory();
        JerialContext context1 = new JerialContext(factory);
        Jerializer<Post> jerializer = new PostJerializer();
        jerializer.jerialize(post, context1);
        Jerial jerial = context1.builder.buildJerial();

        JerialVisitor<StringBuilder> objectWriter = new JsonObjectWriter();
        Writer<StringBuilder> stringWriter = (new JerialRunner<StringBuilder>()).runJerialVisitor(jerial, objectWriter);
        StringBuilder sb = new StringBuilder();
        stringWriter.writeTo(sb);
        String s = sb.toString();
        assertEquals("{\"body\":\"bar\",\"title\":\"foo\"}", s);

        JerialVisitor<JerialContext> reader = new JsonObjectReader();
        Writer<JerialContext> contextWriter = (new JsonParser<JerialContext>()).runJerialVisitor(s, reader);
        JerialContext context2 = new JerialContext(factory);
        contextWriter.writeTo(context2);

        int i = 0;
        for (Jitem entry : context2.builder.buildJerial()) {
            Logger.log(entry);
            switch (i) {
                case 0:
                    assertEquals("body", entry.key);
                    assertEquals("bar", entry.value);
                    assertEquals(Jitem.Model.STRING, entry.model);
                    break;
                case 1:
                    assertEquals("title", entry.key);
                    assertEquals("foo", entry.value);
                    assertEquals(Jitem.Model.STRING, entry.model);
                    break;
                default:
                    fail();
            }
            i += 1;
        }
        assertEquals(2, i);
    }
}
