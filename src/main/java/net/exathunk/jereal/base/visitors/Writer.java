package net.exathunk.jereal.base.visitors;

public interface Writer<T> {
    void writeTo(T out);
}
