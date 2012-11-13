package net.exathunk.jereal.gen;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.dsl.DomainContext;
import net.exathunk.jereal.base.dsl.JThingContext;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.util.Logger;
import net.exathunk.jereal.genschema.GenschemaRegistryFactory;
import net.exathunk.jereal.genschema.schema.Schema;
import net.exathunk.jereal.genschema.schema.SchemaJerializer;
import net.exathunk.jereal.schema.util.Loader;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * charolastra 11/2/12 9:15 PM
 */
public class TestGen {
    /*@Test
    public void testBasic() throws JerializerException {
        final String s = "{ \"id\":\"http://example.com/bongo\", \"properties\": { \"id\": { \"type\":\"string\" }, \"count\": { \"type\":\"integer\" }, \"confuzed\": { \"type\": [\"number\", \"boolean\"] }, \"ordered\" : { \"type\":\"array\", \"items\":\"integer\" } } }";

        final GenWritable gen = RunGen.parseSchemaThing("Bongo", "com.example.bongo", JerializerUtils.jsonToJThing(s));

        for (Map.Entry<String, String> entry : gen.makeClassToTextMap().entrySet()) {
            System.out.println("CLASS: "+entry.getKey());
            System.out.print(entry.getValue());
        }
    }*/

    @Test
    public void testSchema() throws JerializerException, IOException, VisitException {
        final Schema schema = new Schema();
        final String gold = Loader.loadSchemaString("address");
        assertFalse(gold.isEmpty());
        final JThing j = JerializerUtils.jsonToJThing(gold);
        final String silver = JerializerUtils.jthingToJson(j);

        JerializerUtils.jsonToDomain((new GenschemaRegistryFactory()).makeJerializerRegistry(), new SchemaJerializer<DomainContext, JThing>(), gold, schema);

        final String bronze = JerializerUtils.domainToJson((new GenschemaRegistryFactory()).makeJerializerRegistry(), new SchemaJerializer<JThingContext, JThing>(), schema);

        //assertEquals(silver, bronze);

        final Schema schema2 = new Schema();
        JerializerUtils.jsonToDomain((new GenschemaRegistryFactory()).makeJerializerRegistry(), new SchemaJerializer<DomainContext, JThing>(), bronze, schema2);

        assertEquals(schema, schema2);

    }

}
