package net.exathunk.jereal.schemas;

import net.exathunk.jereal.TestUtils;
import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.schema.Loader;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * charolastra 10/24/12 7:59 PM
 */
public class TestLoader {

    private static void assertFixed(final JerialBuilderFactory factory, final String name) throws IOException, JerializerException {
        final String gold = Loader.loadSchemaResource(name);
        assertFalse(gold.isEmpty());
        final Jerial j = TestUtils.jerializeFromString(factory, gold);
        final String s = TestUtils.jerializeToString(factory, j, new JerialJerializer());
        Logger.log("READ " + name + " => " + s);
        // TODO add assertions
    }

    @Test
    public void testLoadSchema() throws IOException, JerializerException {
        List<JerialBuilderFactory> factories = Arrays.asList(
                new SimpleMapBuilderFactory(),
                new FlattenedBuilderFactory(new DefaultPathConverter())
        );
        //List<String> names = Arrays.asList("json-ref");
        List<String> names = Arrays.asList(
                "address", "calendar", "card", "geo",
                "hyper-schema", "interfaces", "json-ref", "schema");
        for (final JerialBuilderFactory factory : factories) {
            for (final String name : names) {
                assertFixed(factory, name);
            }
        }
    }
}
