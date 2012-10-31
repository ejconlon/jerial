package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/23/12 9:46 PM
 */
public class ArrJerializer implements Jerializer<Arr, JerialContext> {
    @Override
    public void jerialize(JDSL<JerialContext> jdsl, JerializerRegistry<JerialContext> registry, Arr arr, JerialContext context) throws JerializerException{
        jdsl.addList(registry, PathPart.key("objects"), arr.objects, context);
    }
}
