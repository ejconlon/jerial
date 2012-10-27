package net.exathunk.jereal.base;

public interface Jerializer<T> {
    void jerialize(JerializerRegistry registry, T object, JerialContext context) throws JerializerException;
}
