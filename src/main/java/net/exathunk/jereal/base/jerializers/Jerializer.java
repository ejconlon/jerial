package net.exathunk.jereal.base.jerializers;

public interface Jerializer<T> {
    void jerialize(JDSL jdsl, T object) throws JerializerException;
}
