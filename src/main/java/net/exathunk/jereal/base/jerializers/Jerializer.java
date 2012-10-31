package net.exathunk.jereal.base.jerializers;

public interface Jerializer<T, C> {
    void jerialize(JDSL<C> jdsl, JerializerRegistry<C> registry, T object, C context) throws JerializerException;
}
