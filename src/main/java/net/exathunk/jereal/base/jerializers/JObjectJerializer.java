package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.Map;

/**
 * Puzzling class, to be sure.
 * The point it that you can reprocess all items with the given builder in the context.
 *
 * charolastra 10/24/12 8:06 PM
 */
public class JObjectJerializer implements Jerializer<JObject, JerialContext> {
    @Override
    public void jerialize(JDSL<JerialContext> jdsl, JerializerRegistry<JerialContext> registry, JObject object, JerialContext context) {
        for (Map.Entry<String, JThing> thing : object.seq()) {
            jdsl.addThing(PathPart.key(thing.getKey()), new RefImpl<JThing>(thing.getValue()), context);
        }
    }
}
