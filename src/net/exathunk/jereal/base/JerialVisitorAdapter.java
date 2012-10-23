package net.exathunk.jereal.base;

public interface JerialVisitorAdapter<T> {
    void runJerialVisitor(T object, JerialVisitor visitor) throws JerializerException;
}
