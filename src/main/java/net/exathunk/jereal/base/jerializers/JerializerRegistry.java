package net.exathunk.jereal.base.jerializers;

/**
 * charolastra 10/27/12 3:08 PM
 */
public interface JerializerRegistry<C> {
    <T> boolean hasJerializer(Class<T> key);
    <T> Jerializer<T, C> getJerializer(Class<T> key) throws JerializerException;
}
