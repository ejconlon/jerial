package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.DomainContext;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.util.Logger;
import net.exathunk.jereal.schema.jerializers.SchemaJerializer;
import net.exathunk.jereal.schema.util.Loader;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.util.SchemaRegistryBuilder;
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

    static {
        Logger.getPolicyBuilder().add(TestLoader.class, Logger.Level.INFO);
    }

    private static void assertFixed(final JerializerRegistry registry,
                                    final String name) throws IOException, JerializerException, VisitException {
        final String gold = Loader.loadSchemaString(name);
        assertFalse(gold.isEmpty());
        final JThing j = JerializerUtils.jsonToJThing(gold);
        final String s1 = JerializerUtils.jthingToJson(j);
        Logger.getLogger(TestLoader.class).trace("READ " + name + " => " + s1);

        final Schema schema = Loader.loadSchema(name);

        Logger.getLogger(TestLoader.class).trace("SCHEMA "+schema);

        final String s2 = JerializerUtils.domainToJson(registry, schema);

        // TODO better assertions... fixpoints are easy though
        assertEquals(s1, s2);

        final Schema schema2 = new Schema();
        JerializerUtils.jsonToDomain(registry, new SchemaJerializer<DomainContext, JThing>(), s2, schema2);

        assertEquals(schema, schema2);
    }

    @Test
    public void testLoadSchema() throws IOException, JerializerException, VisitException {
        List<String> names = Arrays.asList(
                "address", "calendar", "card", "geo",
                "hyper-schema", "interfaces", "json-ref", "schema");

        final JerializerRegistry registry =
                (new SchemaRegistryBuilder()).makeJerializerRegistry();

        for (final String name : names) {
            assertFixed(registry, name);
        }
    }
}
