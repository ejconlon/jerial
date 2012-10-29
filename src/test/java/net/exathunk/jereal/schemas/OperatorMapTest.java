package net.exathunk.jereal.schemas;

import net.exathunk.jereal.base.operators.DeclarationException;
import net.exathunk.jereal.base.operators.ExecutionException;
import net.exathunk.jereal.base.operators.OperatorMap;
import net.exathunk.jereal.schema.Schema;
import net.exathunk.jereal.schema.SchemaOperatorMapBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * charolastra 10/29/12 2:59 PM
 */
public class OperatorMapTest {
    @Test
    public void testSchema() throws DeclarationException {
        SchemaOperatorMapBuilder b = new SchemaOperatorMapBuilder();
        OperatorMap<Schema, ExecutionException> m = new OperatorMap<Schema, ExecutionException>();
        b.buildOperatorMap(m);
        assertEquals(false, m.isEmpty());
    }
}
