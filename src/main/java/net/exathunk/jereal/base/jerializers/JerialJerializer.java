package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.core.Jitem;

/**
 * Puzzling class, to be sure.
 * The point it that you can reprocess all items with the given builder in the context.
 *
 * charolastra 10/24/12 8:06 PM
 */
public class JerialJerializer implements Jerializer<Jerial> {
    @Override
    public void jerialize(JerializerRegistry registry, Jerial object, JerialContext context) {
        for (Jitem jitem : object) {
            context.builder.addJitem(jitem);
        }
    }
}
