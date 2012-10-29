package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.jerializers.DeclarationException;
import net.exathunk.jereal.base.jerializers.OperatorMap;
import net.exathunk.jereal.schema.Schema;
import net.exathunk.jereal.schema.SchemaOperatorMapBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * charolastra 10/29/12 2:59 PM
 */
public class OperatorMapTest {
    @Test
    public void testSchema() throws DeclarationException {
        SchemaOperatorMapBuilder b = new SchemaOperatorMapBuilder();
        OperatorMap<Schema> m = new OperatorMap<Schema>();
        b.buildOperatorMap(m);
        assertEquals(false, m.isEmpty());
    }
}
