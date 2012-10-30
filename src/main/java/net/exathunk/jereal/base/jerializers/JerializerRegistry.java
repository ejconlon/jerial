package net.exathunk.jereal.base.jerializers;

/**
 * charolastra 10/27/12 3:08 PM
 */
public interface JerializerRegistry {
    <T> boolean hasJerializer(Class<T> key);
    <T> Jerializer<T> getJerializer(Class<T> key) throws JerializerException;
}
