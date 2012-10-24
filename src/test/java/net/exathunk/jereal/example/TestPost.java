package net.exathunk.jereal.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import net.exathunk.jereal.base.*;

public class TestPost {

    private final JerialBuilderFactory factory = new SimpleMapBuilderFactory();

    <T> String jerializeToString(JerialBuilderFactory f, T x, Jerializer<T> y) {
        JerialContext context = new JerialContext(f);
        y.jerialize(x, context);
        Jerial jerial = context.builder.buildJerial();
        JerialVisitor<StringBuilder> objectWriter = new JsonObjectWriter();
        Writer<StringBuilder> stringWriter = (new JerialRunner<StringBuilder>()).runJerialVisitor(jerial, objectWriter);
        StringBuilder sb = new StringBuilder();
        stringWriter.writeTo(sb);
        return sb.toString();
    }

    <T> Jerial jerializeFromString(JerialBuilderFactory f, String x) throws JerializerException {
        JerialVisitor<JerialContext> reader = new JsonObjectReader();
        Writer<JerialContext> contextWriter = (new JsonParser<JerialContext>()).runJerialVisitor(x, reader);
        JerialContext context = new JerialContext(factory);
        contextWriter.writeTo(context);
        return context.builder.buildJerial();
    }

    @Test
    public void testSerializePost() throws JerializerException {
        final Post post = new Post("foo", "bar");
        final String gold = "{\"body\":\"bar\",\"title\":\"foo\"}";

        final String s = jerializeToString(factory, post, new PostJerializer());
        assertEquals(gold, s);

        final Jerial j = jerializeFromString(factory, gold);

        int i = 0;
        for (Jitem entry : j) {
            Logger.log(entry);
            switch (i) {
                case 0:
                    assertEquals("body", entry.key);
                    assertEquals(post.body, entry.value);
                    assertEquals(Jitem.Model.STRING, entry.model);
                    break;
                case 1:
                    assertEquals("title", entry.key);
                    assertEquals(post.title, entry.value);
                    assertEquals(Jitem.Model.STRING, entry.model);
                    break;
                default:
                    fail();
            }
            i += 1;
        }
        assertEquals(2, i);
    }

    @Test
    public void testNulls() {
        final Bag bag0 = new Bag(null, null, null, null);
        final String gold0 = "{\"d\":null,\"s\":null,\"b\":null,\"l\":null}";
        final String s0 = jerializeToString(factory, bag0, new BagJerializer());
        assertEquals(gold0, s0);
    }

    @Test
    public void testBag() {
        final Bag bag0 = new Bag("x", (long) 12, 4.5, true);
        final Bag bag1 = new Bag("y", (long) 13, 6.7, false, bag0);

        final String gold0 = "{\"d\":4.5,\"s\":\"x\",\"b\":true,\"l\":12}";
        final String s0 = jerializeToString(factory, bag0, new BagJerializer());
        assertEquals(gold0, s0);

        final String gold1 = "{\"d\":6.7,\"s\":\"y\",\"b\":false,\"next\":"+gold0+",\"l\":13}";
        final String s1 = jerializeToString(factory, bag1, new BagJerializer());
        assertEquals(gold1, s1);

    }
}
