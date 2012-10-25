package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

/**
 * charolastra 10/24/12 8:06 PM
 */
public class JerialJerializer implements Jerializer<Jerial> {
    @Override
    public void jerialize(Jerial object, JerialContext context) {
        for (Jitem jitem : object) {
            context.builder.addJitem(jitem);
        }
    }
}
