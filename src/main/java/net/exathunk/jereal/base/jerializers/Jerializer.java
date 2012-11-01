package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;

public interface Jerializer<T extends PushableContext<T, U>, U, V> {
    void jerialize(Recurser<T, U> recurser, ObjectDSL<T, U> dsl, V object) throws JerializerException;
}
