package net.exathunk.jereal.base;

public interface JerialWriter<T> extends JerialVisitor {
    void writeJerial(T out);
}
