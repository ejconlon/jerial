package net.exathunk.jereal.base;

public interface JerialVisitorAdapter<T, U> {
    Writer<U> runJerialVisitor(T object, JerialVisitor<U> visitor) throws JerializerException;
}
