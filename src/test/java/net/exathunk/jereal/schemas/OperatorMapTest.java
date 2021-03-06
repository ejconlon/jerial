package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.operators.*;
import net.exathunk.jereal.base.operators.declaration.DeclarationException;
import net.exathunk.jereal.base.util.Logger;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.operators.SchemaOperatorMapBuilder;
import net.exathunk.jereal.schema.util.Loader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * charolastra 10/29/12 2:59 PM
 */
public class OperatorMapTest {

    static {
           //Logger.getPolicyBuilder().add(OperatorMapTest.class, Logger.Level.DEBUG);
    }

    private static JThing loadSchema(String name) throws IOException, JerializerException {
        final String s = Loader.loadSchemaString(name);
        final JThing j = JerializerUtils.jsonToJThing(s);
        return j;
    }

    private static OperatorMap<JThing, Schema> makeSchemaMap() throws DeclarationException {
        SchemaOperatorMapBuilder b = new SchemaOperatorMapBuilder();
        OperatorMap<JThing, Schema> m = new OperatorMap<JThing, Schema>();
        b.buildOperatorMap(m);
        return m;
    }

    @Test
    public void testSchema() throws DeclarationException {
        final OperatorMap<JThing, Schema> m = makeSchemaMap();
        assertEquals(false, m.isEmpty());
    }

    @Test
    public void testSchemaSerialization() throws DeclarationException, IOException, JerializerException, VisitException {
        final OperatorMap<JThing, Schema> opMap = makeSchemaMap();
        final JThing j = loadSchema("schema");
        final OpContext<JThing, Schema> context = new OpContext<JThing, Schema>(opMap, new RefImpl<OperatorException>());
        final Schema domain = new Schema();
        final OperatorVisitor<Schema> v = new OperatorVisitor<Schema>(context, domain);

        assertEquals(true, domain.id.isEmptyRef());
        j.acceptUntyped(Path.root(), v);
        Logger.getLogger(getClass()).debug(domain);
        assertEquals("http://json-schema.org/schema#", domain.id.getRef());
    }
}
