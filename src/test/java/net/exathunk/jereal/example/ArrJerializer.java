package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JerialContext;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.visitors.Jitem;

/**
 * charolastra 10/23/12 9:46 PM
 */
public class ArrJerializer implements Jerializer<Arr> {
    @Override
    public void jerialize(Arr arr, JerialContext context) {
        context.builder.addJitem(Jitem.makeArray("objects", arr.objects));
    }
}
