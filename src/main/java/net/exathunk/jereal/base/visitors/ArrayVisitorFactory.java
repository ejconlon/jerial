package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/23/12 10:18 PM
 */
public interface ArrayVisitorFactory<T> {
    ArrayVisitor<T> makeArrayVisitor();
}
