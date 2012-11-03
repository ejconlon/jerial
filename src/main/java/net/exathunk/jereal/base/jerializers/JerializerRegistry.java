package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;

/**
 * charolastra 10/27/12 3:08 PM
 */
public interface JerializerRegistry<T extends PushableContext<T, U>, U extends Questionable> {
    <V> boolean hasJerializer(Class<V> key);
    <V> Jerializer<T, U, V> getJerializer(Class<V> key) throws JerializerException;
}
