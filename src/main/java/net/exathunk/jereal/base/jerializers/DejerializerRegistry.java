package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.JerializerException;

/**
 * charolastra 10/27/12 3:10 PM
 */
public interface DejerializerRegistry {
    <T> boolean hasDejerializer(Class<T> key);
    <T> Dejerializer<T> getDejerializer(Class<T> key) throws JerializerException;
}