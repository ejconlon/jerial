package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.*;
import net.exathunk.jereal.base.builders.JerialBuilderFactory;
import net.exathunk.jereal.base.builders.SimpleMapBuilderFactory;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.visitors.VisitException;
import net.exathunk.jereal.schema.Loader;
import net.exathunk.jereal.schema.Schema;
import net.exathunk.jereal.schema.SchemaRegistryFactorySingleton;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * charolastra 10/24/12 7:59 PM
 */
public class TestLoader {

    private static void assertFixed(final JerialBuilderFactory factory, final JerializerRegistry registry,
                                    final String name) throws IOException, JerializerException, VisitException {
        final String gold = Loader.loadSchemaString(name);
        assertFalse(gold.isEmpty());
        final JObject j = JerializerUtils.jsonToJObject(gold);
        final String s1 = JerializerUtils.jobjectToJson(j);
        Logger.log(Logger.Level.TRACE, "READ " + name + " => " + s1);

        final Schema schema = Loader.loadSchema(factory, name);

        Logger.log(Logger.Level.TRACE, "SCHEMA "+schema);

        final String s2 = JerializerUtils.domainToJson(factory, registry, schema);

        // TODO better assertions... fixpoints are easy though
        assertEquals(s1, s2);
    }

    @Test
    public void testLoadSchema() throws IOException, JerializerException, VisitException {
        List<JerialBuilderFactory> factories = Arrays.asList(
                (JerialBuilderFactory)new SimpleMapBuilderFactory());

        List<String> names = Arrays.asList(
                "address", "calendar", "card", "geo",
                "hyper-schema", "interfaces", "json-ref", "schema");

        final JerializerRegistry registry =
                SchemaRegistryFactorySingleton.getInstance().makeJerializerRegistry();

        for (final JerialBuilderFactory factory : factories) {
            for (final String name : names) {
                assertFixed(factory, registry, name);
            }
        }
    }
}
