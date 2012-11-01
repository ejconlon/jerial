package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/23/12 9:46 PM
 */
public class ArrJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Arr> {
    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Arr arr) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("objects", recurser.seeCustomList(dsl, arr.objects));
        return objectDSL;
    }
}
