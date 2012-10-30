package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JsonParser;
import net.exathunk.jereal.base.Logger;
import net.exathunk.jereal.base.core.JThing;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * charolastra 10/29/12 7:56 PM
 */
public class JsonParserTest {
    @Test
    public void testSimple() {
        JsonParser parser = new JsonParser();
        final String gold0 = "{\"b\":true,\"d\":4.5,\"l\":12,\"s\":\"x\"}";
        final String gold1 = "{\"b\":false,\"d\":6.7,\"l\":13,\"next\":"+gold0+",\"s\":\"y\"}";
        JThing thing = parser.parse(gold1);
        Logger.log(Logger.Level.TRACE, thing);
        assertNotNull(thing);
    }
}
