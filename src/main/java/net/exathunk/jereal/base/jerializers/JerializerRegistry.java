package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.jerializers.Jerializer;

/**
 * charolastra 10/27/12 3:08 PM
 */
public interface JerializerRegistry {
    <T> boolean hasJerializer(Class<T> key);
    <T> Jerializer<T> getJerializer(Class<T> key) throws JerializerException;
}
