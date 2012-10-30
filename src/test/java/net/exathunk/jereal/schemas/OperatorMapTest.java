package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.EitherRef;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.operators.*;
import net.exathunk.jereal.base.operators.declaration.DeclarationException;
import net.exathunk.jereal.base.operators.declaration.OpOutput;
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
           Logger.getPolicyBuilder().add(OperatorMapTest.class, Logger.Level.DEBUG);
    }

    private static JObject loadSchema(String name) throws IOException, JerializerException {
        final String s = Loader.loadSchemaString(name);
        final JObject j = JerializerUtils.jsonToJObject(s);
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
        assertEquals(false, m.dir(Direction.SERIALIZE).isEmpty());
    }

    @Test
    public void testSchemaSerialization() throws DeclarationException, IOException, JerializerException, VisitException {
        final OperatorMap<JThing, Schema> m = makeSchemaMap();
        final JObject j = loadSchema("schema");
        final OpContext<JThing, Schema> context = new OpContext<JThing, Schema>(Direction.SERIALIZE, Path.root(), SuperModel.OBJECT, null, EitherRef.<Schema, OperatorException>makeLeftRef(new Schema()));
        final OperatorMapVisitor<Schema> v = new OperatorMapVisitor<Schema>(m, context);

        assertEquals(null, context.out.getLeft().format);
        j.accept(Path.root(), v);
        Logger.getLogger(getClass()).debug(context.out.getLeft());
        assertEquals("uri", context.out.getLeft().format);
    }
}
