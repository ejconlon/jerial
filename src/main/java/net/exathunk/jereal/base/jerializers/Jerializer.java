package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.*;

public interface Jerializer<T extends PushableContext<T, U>, U extends Questionable, V> {
    V prototype(Speclike spec) throws JerializerException;
    Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, V object) throws JerializerException;
}
