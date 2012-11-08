package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.Pipeable;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;

/**
 * charolastra 11/7/12 4:55 PM
 */
public interface SimpleJerializer<T extends PushableContext<T, U>, U extends Questionable, V> {
    Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, V object) throws JerializerException;
}
