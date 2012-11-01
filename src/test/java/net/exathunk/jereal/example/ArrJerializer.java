package net.exathunk.jereal.example;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.*;

/**
 * charolastra 10/23/12 9:46 PM
 */
public class ArrJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Arr> {

    private static <V> Ref<V> ref(V v) { return new RefImpl<V>(v); }

    @Override
    public Arr prototype() {
        return new Arr();
    }

    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Arr arr) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("objects", ref(recurser.seeCustomList(dsl, arr.objects, Post.class)));
        return objectDSL;
    }
}
