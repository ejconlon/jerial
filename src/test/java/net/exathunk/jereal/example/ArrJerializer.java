package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/23/12 9:46 PM
 */
public class ArrJerializer implements Jerializer<Arr> {
    @Override
    public void jerialize(JerializerRegistry registry, Arr arr, JerialContext context) {
        context.builder.addJitem(Jitem.makeArray(PathPart.key("objects"), arr.objects));
    }
}
