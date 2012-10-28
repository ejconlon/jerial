package net.exathunk.jereal.base.visitors;

public interface VisitorFactory<T> {
    ArrayVisitor<T> makeArrayVisitor();
    ObjectVisitor<T> makeObjectVisitor();
}
