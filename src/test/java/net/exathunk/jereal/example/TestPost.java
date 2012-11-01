package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.MapBuilder;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.dsl.DomainContext;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.util.FlattenVisitor;
import net.exathunk.jereal.base.util.Logger;
import net.exathunk.jereal.schema.util.Loader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.*;

public class TestPost {

    static {
        Logger.getPolicyBuilder().add(TestPost.class, Logger.Level.CRITICAL)
                .add(MapBuilder.class, Logger.Level.TRACE);
        registry = new SinglyRegistry(Arr.class, new ArrJerializer(),
                   new SinglyRegistry(Bag.class, new BagJerializer(),
                   new SinglyRegistry(Post.class, new PostJerializer())));
    }

    private static final JerializerRegistry registry;

    @Test
    public void testSerializePost() throws JerializerException, VisitException {
        final Post post = new Post("foo", "bar");
        final String gold = "{\"body\":\"bar\",\"title\":\"foo\"}";

        final String s = JerializerUtils.domainToJson(registry, new PostJerializer(), post);
        assertEquals(gold, s);

        final JThing j = JerializerUtils.jsonToJThing(gold);

        int i = 0;
        for (Map.Entry<String, JThing> entry : j.rawGetObject().seq()) {
            Logger.getLogger(getClass()).trace(entry);
            switch (i) {
                case 0:
                    assertEquals("body", entry.getKey());
                    assertEquals(true, entry.getValue().isString());
                    assertEquals(post.body.getRef(), entry.getValue().rawGetString().getRef());
                    break;
                case 1:
                    assertEquals("title", entry.getKey());
                    assertEquals(true, entry.getValue().isString());
                    assertEquals(post.title.getRef(), entry.getValue().rawGetString().getRef());
                    break;
                default:
                    fail();
            }
            i += 1;
        }
        assertEquals(2, i);
    }

    @Test
    public void testNulls() throws JerializerException, VisitException {
        final Bag bag0 = new Bag(null, null, null, null);
        // TODO this should be the correct output
        final String gold0 = "{\"b\":null,\"d\":null,\"l\":null,\"s\":null}";
        //final String gold0 = "{}";
        final String s0 = JerializerUtils.domainToJson(registry, new BagJerializer(), bag0);
        assertEquals(gold0, s0);
    }

    @Test
    public void testBag() throws JerializerException, VisitException {
        final Bag bag0 = new Bag("x", (long) 12, 4.5, true);
        final Bag bag1 = new Bag("y", (long) 13, 6.7, false, bag0);

        final String gold0 = "{\"b\":true,\"d\":4.5,\"l\":12,\"s\":\"x\"}";
        final String s0 = JerializerUtils.domainToJson(registry, new BagJerializer(), bag0);
        assertEquals(gold0, s0);

        final JThing j0 = JerializerUtils.jsonToJThing(gold0);
        for (Map.Entry<String, JThing> entry : j0.rawGetObject().seq()) {
            Logger.getLogger(getClass()).trace(entry);
            // TODO add assertions
        }

        final String gold1 = "{\"b\":false,\"d\":6.7,\"l\":13,\"next\":"+gold0+",\"s\":\"y\"}";
        final String s1 = JerializerUtils.domainToJson(registry, new BagJerializer(), bag1);
        assertEquals(gold1, s1);

        final JThing j1 = JerializerUtils.jsonToJThing(gold1);
        for (Map.Entry<String, JThing> entry : j1.rawGetObject().seq()) {
            Logger.getLogger(getClass()).trace(entry);
            // TODO add assertions
        }

        final Bag bag2 = new Bag();
        JerializerUtils.jthingToDomain(registry, new BagJerializer<DomainContext, JThing>(), j1, bag2);

        assertEquals(true, bag1.equals(bag2));
    }

    @Test
    public void testArray() throws JerializerException, VisitException {
        final Arr arr = new Arr(new Post("foo", "bar"), new Post("baz", "quux"));
        final String gold = "{\"objects\":[{\"body\":\"bar\",\"title\":\"foo\"},{\"body\":\"quux\",\"title\":\"baz\"}]}";
        final String s = JerializerUtils.domainToJson(registry, new ArrJerializer(), arr);
        assertEquals(gold, s);

        final JThing j = JerializerUtils.jsonToJThing(gold);

        int i = 0;
        for (Map.Entry<String, JThing> entry : j.rawGetObject().seq()) {
            int k = 0;
            Logger.getLogger(getClass()).trace(entry);
            switch (i) {
                case 0:
                    assertEquals("objects", entry.getKey());
                    assertEquals(true, entry.getValue().isArray());
                    for (Map.Entry<Integer, JThing> entry1 : entry.getValue().rawGetArray().seq()) {
                        Post actual = arr.objects.getRef().get(k++);
                        JThing expected = entry1.getValue();
                        assertEquals(expected.rawGetObject().get("body").getOrDefault(null).rawGetString().getRef(), actual.body.getRef());
                        assertEquals(expected.rawGetObject().get("title").getOrDefault(null).rawGetString().getRef(), actual.title.getRef());
                    }
                    break;
                default:
                    fail();
            }
            i += 1;
        }
        assertEquals(1, i);


        final Arr arr2 = new Arr();
        JerializerUtils.jthingToDomain(registry, new ArrJerializer<DomainContext, JThing>(), j, arr2);

        assertEquals(true, arr.equals(arr2));
    }

    private static Set<String> pathParts(JObject jobject) {
        Set<String> set = new TreeSet<String>();
        for (Map.Entry<String, JThing> entry : jobject.seq()) {
            set.add(entry.getKey());
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
    public void testFlattening() throws JerializerException, VisitException {
        final String gold0 = "{\"b\":true,\"d\":4.5,\"l\":12,\"s\":\"x\"}";
        final String gold1 = "{\"b\":false,\"d\":6.7,\"l\":13,\"next\":"+gold0+",\"s\":\"y\",\"z\":[4,5,6]}";

        final JThing j1 = JerializerUtils.jsonToJThing(gold1);
        for (Map.Entry<String, JThing> entry : j1.rawGetObject().seq()) {
            Logger.getLogger(getClass()).trace(entry);
        }

        FlattenVisitor visitor = new FlattenVisitor();
        j1.acceptTyped(Path.root(), visitor);

        final JObject j2 = visitor.runResFunc();
        for (Map.Entry<String, JThing> entry : j2.seq()) {
            Logger.getLogger(getClass()).trace(entry);
        }

        Set<String> expectedKeys = asSet(
                "/b","/d","/l","/s",
                "/next/b","/next/d","/next/l","/next/s",
                "/z/0", "/z/1", "/z/2");
        Set<String> actualKeys = pathParts(j2);
        assertEquals(expectedKeys, actualKeys);

        final String s2 = JerializerUtils.jthingToJson(JThing.make(j2));
        Logger.getLogger(getClass()).trace(s2);
    }

    public void runFlatteningTest(String gold, Set<String> expectedKeys) throws JerializerException, VisitException {
        final JThing j1 = JerializerUtils.jsonToJThing(gold);
        for (Map.Entry<String, JThing> entry : j1.rawGetObject().seq()) {
            Logger.getLogger(getClass()).trace(entry);
        }

        FlattenVisitor visitor = new FlattenVisitor();
        j1.acceptTyped(Path.root(), visitor);

        final JObject j2 = visitor.runResFunc();

        for (Map.Entry<String, JThing> entry : j2.seq()) {
            Logger.getLogger(getClass()).info(entry);
        }

        Set<String> actualKeys = pathParts(j2);
        if (expectedKeys != null) assertEquals(expectedKeys, actualKeys);
    }

    @Test
    public void testMoreFlattening() throws JerializerException, VisitException, IOException {
        runFlatteningTest(
                "{\"a\":{\"b\":{\"c\":1}}}",
                asSet("/a/b/c"));

        List<String> names = Arrays.asList(
                "address", "calendar", "card", "geo",
                "hyper-schema", "interfaces", "json-ref", "schema");

        for (String name : names) {
            Logger.getLogger(getClass()).info("\n\nNAME: "+name);
            runFlatteningTest(Loader.loadSchemaString(name), null);
        }
    }

    private static class FluMap<A, B> {
        public Map<A, B> map = new TreeMap<A, B>();
        public FluMap put(A k, B v) { map.put(k, v); return this; }
    }

    @Test
    public void testPathConvert() {
        Map<Path, String> map = (new FluMap<Path, String>())
                .put(Path.root(), "")
                .put(Path.root().consKey("a"), "/a")
                .put(Path.root().consIndex(0), "/0")
                .put(Path.root().consKey("b").consIndex(1), "/b/1")
                .put(Path.root().consIndex(2).consKey("c"), "/2/c")
                .map;
        for (Map.Entry<Path, String> entry : map.entrySet()) {
            assertEquals(entry.getValue(), entry.getKey().convert());
        }
    }
}
