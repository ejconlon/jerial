package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;

public interface Jerializer<T extends PushableContext<T, U>, U, V> {
    V prototype();
    Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, V object) throws JerializerException;
}
