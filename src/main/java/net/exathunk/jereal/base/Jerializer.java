package net.exathunk.jereal.base;

public interface Jerializer<T> {
    void jerialize(T object, JerialContext context);
}
