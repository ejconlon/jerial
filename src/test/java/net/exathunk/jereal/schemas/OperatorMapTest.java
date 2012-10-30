package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.functional.EitherRef;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.operators.Direction;
import net.exathunk.jereal.base.operators.declaration.DeclarationException;
import net.exathunk.jereal.base.operators.ExecutionException;
import net.exathunk.jereal.base.operators.OperatorMap;
import net.exathunk.jereal.base.operators.OperatorMapVisitor;
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

    private static OperatorMap<Schema, ExecutionException> makeSchemaMap() throws DeclarationException {
        SchemaOperatorMapBuilder b = new SchemaOperatorMapBuilder();
        OperatorMap<Schema, ExecutionException> m = new OperatorMap<Schema, ExecutionException>();
        b.buildOperatorMap(m);
        return m;
    }

    @Test
    public void testSchema() throws DeclarationException {
        final OperatorMap<Schema, ExecutionException> m = makeSchemaMap();
        assertEquals(false, m.dir(Direction.SERIALIZE).isEmpty());
    }

    @Test
    public void testSchemaSerialization() throws DeclarationException, IOException, JerializerException, VisitException {
        final OperatorMap<Schema, ExecutionException> m = makeSchemaMap();
        final JObject j = loadSchema("schema");
        final EitherRef<Schema, ExecutionException> r = EitherRef.makeLeftRef(new Schema());
        final OperatorMapVisitor<Schema, ExecutionException> v = new OperatorMapVisitor<Schema, ExecutionException>(m, Direction.SERIALIZE, r);

        assertEquals(null, r.getLeft().format);
        j.accept(Path.root(), v);
        Logger.getLogger(getClass()).debug(r.getLeft());
        assertEquals("uri", r.getLeft().format);
    }
}
