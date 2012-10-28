package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialBuilderFactory;
import net.exathunk.jereal.base.builders.SimpleMapBuilderFactory;
import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.jerializers.JerialJerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerRegistryImpl;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.DefaultPathConverter;
import net.exathunk.jereal.base.builders.FlattenedBuilderFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import net.exathunk.jereal.base.*;

import java.util.Set;
import java.util.TreeSet;

public class TestPost {

    private final JerializerRegistry emptyRegistry = new JerializerRegistryImpl();
    private final JerialBuilderFactory factory = new SimpleMapBuilderFactory();

    @Test
    public void testSerializePost() throws JerializerException {
        final Post post = new Post("foo", "bar");
        final String gold = "{\"body\":\"bar\",\"title\":\"foo\"}";

        final String s = JerializerUtils.domainToJson(factory, emptyRegistry, new PostJerializer(), post);
        assertEquals(gold, s);

        final Jerial j = JerializerUtils.jsonToJerial(factory, gold);

        int i = 0;
        for (Jitem entry : j) {
            Logger.log(entry);
            switch (i) {
                case 0:
                    assertEquals("body", entry.getPart().getLeft());
                    assertEquals(post.body, entry.getString());
                    assertEquals(Jitem.Model.STRING, entry.getModel());
                    break;
                case 1:
                    assertEquals("title", entry.getPart().getLeft());
                    assertEquals(post.title, entry.getString());
                    assertEquals(Jitem.Model.STRING, entry.getModel());
                    break;
                default:
                    fail();
            }
            i += 1;
        }
        assertEquals(2, i);
    }

    @Test
    public void testNulls() throws JerializerException {
        final Bag bag0 = new Bag(null, null, null, null);
        final String gold0 = "{\"b\":null,\"d\":null,\"l\":null,\"s\":null}";
        final String s0 = JerializerUtils.domainToJson(factory, emptyRegistry, new BagJerializer(), bag0);
        assertEquals(gold0, s0);
    }

    @Test
    public void testBag() throws JerializerException {
        final Bag bag0 = new Bag("x", (long) 12, 4.5, true);
        final Bag bag1 = new Bag("y", (long) 13, 6.7, false, bag0);

        final String gold0 = "{\"b\":true,\"d\":4.5,\"l\":12,\"s\":\"x\"}";
        final String s0 = JerializerUtils.domainToJson(factory, emptyRegistry, new BagJerializer(), bag0);
        assertEquals(gold0, s0);

        final Jerial j0 = JerializerUtils.jsonToJerial(factory, gold0);
        for (Jitem entry : j0) {
            Logger.log(entry);
            // TODO add assertions
        }

        final String gold1 = "{\"b\":false,\"d\":6.7,\"l\":13,\"next\":"+gold0+",\"s\":\"y\"}";
        final String s1 = JerializerUtils.domainToJson(factory, emptyRegistry, new BagJerializer(), bag1);
        assertEquals(gold1, s1);

        final Jerial j1 = JerializerUtils.jsonToJerial(factory, gold1);
        for (Jitem entry : j1) {
            Logger.log(entry);
            // TODO add assertions
        }
    }

    @Test
    public void testArray() throws JerializerException {
        final Arr arr = new Arr((long) 1, 2.2,"xyz", true);
        final String gold = "{\"objects\":[1,2.2,\"xyz\",true]}";
        final String s = JerializerUtils.domainToJson(factory, emptyRegistry, new ArrJerializer(), arr);
        assertEquals(gold, s);

        final Jerial j = JerializerUtils.jsonToJerial(factory, gold);

        int i = 0;
        for (Jitem entry : j) {
            Logger.log(entry);
            switch (i) {
                case 0:
                    assertEquals("objects", entry.getPart().getLeft());
                    assertEquals(arr.objects.size(), entry.getArray().size());
                    for (int k = 0; k < arr.objects.size(); k++) {
                        Jitem actual = arr.objects.get(k);
                        Jitem expected = entry.getArray().get(k);
                        assertEquals(expected, actual);
                    }
                    assertEquals(Jitem.Model.ARRAY, entry.getModel());
                    break;
                default:
                    fail();
            }
            i += 1;
        }
        assertEquals(1, i);
    }

    private static Set<String> pathParts(Jerial Jerial) {
        Set<String> set = new TreeSet<String>();
        for (Jitem jitem : Jerial) {
            set.add(jitem.getPart().getLeft());
        }
        return set;
    }

    private static Set<String> asSet(String... args) {
        Set<String> set = new TreeSet<String>();
        for (String arg : args) {
            set.add(arg);
        }
        return set;
    }

    // TODO add arrays and assertions
    @Test
    public void testFlattening() throws JerializerException {
        final String gold0 = "{\"b\":true,\"d\":4.5,\"l\":12,\"s\":\"x\"}";
        final String gold1 = "{\"b\":false,\"d\":6.7,\"l\":13,\"next\":"+gold0+",\"s\":\"y\",\"z\":[4,5,6]}";

        JerialBuilderFactory flattenedFactory = new FlattenedBuilderFactory(new DefaultPathConverter());

        final Jerial j1 = JerializerUtils.jsonToJerial(flattenedFactory, gold1);
        for (Jitem entry : j1) {
            Logger.log(entry);
        }
        Set<String> expectedKeys = asSet(
                "b","d","l","s",
                "next/b","next/d","next/l","next/s",
                "z/[0]", "z/[1]", "z/[2]");
        Set<String> actualKeys = pathParts(j1);
        assertEquals(expectedKeys, actualKeys);

        final String s1 = JerializerUtils.domainToJson(flattenedFactory, emptyRegistry, new JerialJerializer(), j1);
        Logger.log(s1);
    }

    public void runFlatteningTest(String gold, Set<String> expectedKeys) throws JerializerException {
        JerialBuilderFactory flattenedFactory = new FlattenedBuilderFactory(new DefaultPathConverter());
        final Jerial j1 = JerializerUtils.jsonToJerial(flattenedFactory, gold);
        for (Jitem entry : j1) {
            Logger.log(entry);
        }
        Set<String> actualKeys = pathParts(j1);
        assertEquals(expectedKeys, actualKeys);
    }

    @Test
    public void testMoreFlattening() throws JerializerException {
        runFlatteningTest(
                "{\"a\":{\"b\":{\"c\":1}}}",
                asSet("a/b/c"));
    }
}
