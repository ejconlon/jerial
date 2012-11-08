package net.exathunk.jereal.gen;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * charolastra 11/2/12 9:15 PM
 */
public class TestGen {
    @Test
    public void testBasic() throws JerializerException {
        final String s = "{ \"id\":\"http://example.com/bongo\", \"properties\": { \"id\": { \"type\":\"string\" }, \"count\": { \"type\":\"integer\" } }, }";

        final GenWritable gen = RunGen.parseSchemaThing("Bongo", "com.example.bongo", JerializerUtils.jsonToJThing(s));

        for (Map.Entry<String, String> entry : gen.makeClassToTextMap().entrySet()) {
            System.out.println("CLASS: "+entry.getKey());
            System.out.print(entry.getValue());
        }
    }

}
